package com.example.CarRentalProject.Controllers;

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
    public ResponseEntity<List<CorporateCustomer>> GetAllCustomers() {
        return new ResponseEntity<>(service.GetAll(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public Optional<CorporateCustomer> GetCustomerById(@PathVariable long id) {
        return service.GetById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<CorporateCustomer> CreateCustomer(@RequestBody CorporateCustomer customer) {
        return new ResponseEntity<>(service.Create(customer),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CorporateCustomer> UpdateCustomer(@PathVariable long id,@RequestBody CorporateCustomer customer) {
        return new ResponseEntity<>(service.Update(id,customer),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteCustomer(@PathVariable long id){
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
