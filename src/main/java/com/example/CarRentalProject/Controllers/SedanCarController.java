package com.example.CarRentalProject.Controllers;

import com.example.CarRentalProject.DTOs.RentalRequestDto;
import com.example.CarRentalProject.DTOs.SedanCarRequestDto;
import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Entities.Concrete.SedanCar;
import com.example.CarRentalProject.Services.Concrete.SedanCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sedancar")
@RequiredArgsConstructor
public class SedanCarController {
    private final SedanCarService service;

    @GetMapping
    public ResponseEntity<List<SedanCarRequestDto>> GetAllSedanCar() {
        List<SedanCarRequestDto> dto = service.GetAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SedanCarRequestDto> GetSedanCarById(@PathVariable long id) {
        SedanCarRequestDto dto = service.GetById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> CreateSedanCar(@RequestBody SedanCarRequestDto dto) {
        Boolean isCreated= service.Create(dto);
        return new ResponseEntity<>(isCreated, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> UpdateSedanCar(@PathVariable long id, @RequestBody SedanCarRequestDto dto) {
        Boolean isUpdate=service.Update(id, dto);
        return new ResponseEntity<>(isUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteSedanCar(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
