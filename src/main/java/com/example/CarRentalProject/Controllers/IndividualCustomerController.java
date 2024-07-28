package com.example.CarRentalProject.Controllers;

import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Entities.Concrete.IndividualCustomer;
import com.example.CarRentalProject.Services.Concrete.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/individualcustomer")
@RequiredArgsConstructor
public class IndividualCustomerController {
    private final IndividualCustomerService service;

    @GetMapping
    public ResponseEntity<List<IndividualCustomer>> GetAllIndividualCustomer() {
        return new ResponseEntity<>(service.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<IndividualCustomer> GetIndividualCustomerById(@PathVariable long id) {
        return service.GetById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<IndividualCustomer> CreateIndividualCustomer(@RequestBody IndividualCustomer individualCustomer) {
        return new ResponseEntity<>(service.Create(individualCustomer), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<IndividualCustomer> UpdateIndividualCustomer(@PathVariable long id, @RequestBody IndividualCustomer individualCustomer) {
        return new ResponseEntity<>(service.Update(id, individualCustomer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteIndividualCustomer(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
