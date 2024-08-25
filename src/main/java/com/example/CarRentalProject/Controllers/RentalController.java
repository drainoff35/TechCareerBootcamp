package com.example.CarRentalProject.Controllers;

import com.example.CarRentalProject.DTOs.IndividualCustomerRequestDto;
import com.example.CarRentalProject.DTOs.RentalRequestDto;
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
    public ResponseEntity<List<RentalRequestDto>> GetAllRental() {
        List<RentalRequestDto> dto = service.GetAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalRequestDto> GetRentalById(@PathVariable long id) {
        RentalRequestDto dto = service.GetById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> CreateRental(@RequestBody RentalRequestDto dto) {
        Boolean isCreated= service.Create(dto);
        return new ResponseEntity<>(isCreated, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> UpdateRental(@PathVariable long id, @RequestBody RentalRequestDto dto) {
        Boolean isUpdate=service.Update(id, dto);
        return new ResponseEntity<>(isUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteRental(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
