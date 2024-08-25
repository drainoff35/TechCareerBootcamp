package com.example.CarRentalProject.Controllers;

import com.example.CarRentalProject.DTOs.CorporateCustomerRequestDto;
import com.example.CarRentalProject.Entities.Concrete.CorporateCustomer;
import com.example.CarRentalProject.Services.Concrete.CorporateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/corporatecustomer")
@RequiredArgsConstructor
public class CorporateCustomerController {

    private final CorporateCustomerService service;

    @GetMapping
    public ResponseEntity<List<CorporateCustomerRequestDto>> GetAllCustomers() {
        List<CorporateCustomerRequestDto> dto = service.GetAll();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CorporateCustomerRequestDto> GetCustomerById(@PathVariable long id) {
        CorporateCustomerRequestDto dto=service.GetById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> CreateCustomer(@RequestBody CorporateCustomerRequestDto dto) {
        Boolean isCreated=service.Create(dto);
        return new ResponseEntity<>(isCreated,HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> UpdateCustomer(@PathVariable long id,@RequestBody CorporateCustomerRequestDto dto) {
        Boolean isUpdate = service.Update(id, dto);
        return new ResponseEntity<>(isUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteCustomer(@PathVariable long id){
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
