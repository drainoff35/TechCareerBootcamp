package com.example.CarRentalProject.Controllers;

import com.example.CarRentalProject.DTOs.SUVCarRequestDto;
import com.example.CarRentalProject.DTOs.SedanCarRequestDto;
import com.example.CarRentalProject.Entities.Concrete.SUVCar;
import com.example.CarRentalProject.Entities.Concrete.SedanCar;
import com.example.CarRentalProject.Services.Concrete.SUVCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suvcar")
@RequiredArgsConstructor
public class SUVCarController {
    private final SUVCarService service;

    @GetMapping
    public ResponseEntity<List<SUVCarRequestDto>> GetAllSUVCar() {
        List<SUVCarRequestDto> dto = service.GetAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SUVCarRequestDto> GetSUVCarById(@PathVariable long id) {
        SUVCarRequestDto dto = service.GetById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> CreateSUVCar(@RequestBody SUVCarRequestDto dto) {
        Boolean isCreated= service.Create(dto);
        return new ResponseEntity<>(isCreated, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> UpdateSUVCar(@PathVariable long id, @RequestBody SUVCarRequestDto dto) {
        Boolean isUpdate=service.Update(id, dto);
        return new ResponseEntity<>(isUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteSUVCar(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
