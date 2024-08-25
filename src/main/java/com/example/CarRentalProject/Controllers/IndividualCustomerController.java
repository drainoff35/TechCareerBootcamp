package com.example.CarRentalProject.Controllers;

import com.example.CarRentalProject.DTOs.IndividualCustomerRequestDto;
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
    public ResponseEntity<List<IndividualCustomerRequestDto>> GetAllIndividualCustomer() {
        List<IndividualCustomerRequestDto> dto = service.GetAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndividualCustomerRequestDto> GetIndividualCustomerById(@PathVariable long id) {
        IndividualCustomerRequestDto dto = service.GetById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> CreateIndividualCustomer(@RequestBody IndividualCustomerRequestDto dto) {
        Boolean isCreated= service.Create(dto);
        return new ResponseEntity<>(isCreated, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> UpdateIndividualCustomer(@PathVariable long id, @RequestBody IndividualCustomerRequestDto dto) {
        Boolean isUpdate=service.Update(id, dto);
        return new ResponseEntity<>(isUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteIndividualCustomer(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
