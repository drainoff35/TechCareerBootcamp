package com.example.CarRentalProject.Controllers;

import com.example.CarRentalProject.Entities.Concrete.IndividualCustomer;
import com.example.CarRentalProject.Entities.Concrete.Rental;
import com.example.CarRentalProject.Services.Concrete.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rental")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService service;

    @GetMapping
    public ResponseEntity<List<Rental>> GetAllRental() {
        return new ResponseEntity<>(service.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Rental> GetRentalById(@PathVariable long id) {
        return service.GetById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Rental> CreateRental(@RequestBody Rental rental) {
        return new ResponseEntity<>(service.Create(rental), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Rental> UpdateRental(@PathVariable long id, @RequestBody Rental rental) {
        return new ResponseEntity<>(service.Update(id, rental), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteRental(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
