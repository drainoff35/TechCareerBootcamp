package com.example.CarRentalProject.Controllers;

import com.example.CarRentalProject.DTOs.CorporateCustomerRequestDto;
import com.example.CarRentalProject.DTOs.HatchbackCarRequestDto;
import com.example.CarRentalProject.DTOs.IndividualCustomerRequestDto;
import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Services.Concrete.HatchbackCarService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hatchbackcar")
@RequiredArgsConstructor
public class HatchbackCarController {

    private final HatchbackCarService service;

    @GetMapping
    public ResponseEntity<List<HatchbackCarRequestDto>> GetAllHatchbackCar() {
        List<HatchbackCarRequestDto> dto = service.GetAll();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HatchbackCarRequestDto> GetHatchbackCarById(@PathVariable long id) {
        HatchbackCarRequestDto dto = service.GetById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> CreateHatchbackCar(@RequestBody HatchbackCarRequestDto dto) {
        Boolean isCreated= service.Create(dto);
        return new ResponseEntity<>(isCreated, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> UpdateHatchbackCar(@PathVariable long id, @RequestBody HatchbackCarRequestDto dto) {
        Boolean isUpdate=service.Update(id, dto);
        return new ResponseEntity<>(isUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteHatchbackCar(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
