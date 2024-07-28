package com.example.CarRentalProject.Controllers;

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
    public ResponseEntity<List<SedanCar>> GetAllSedanCar() {
        return new ResponseEntity<>(service.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<SedanCar> GetSedanCarById(@PathVariable long id) {
        return service.GetById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<SedanCar> CreateSedanCar(@RequestBody SedanCar sedanCar) {
        return new ResponseEntity<>(service.Create(sedanCar), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SedanCar> UpdateSedanCar(@PathVariable long id, @RequestBody SedanCar sedanCar) {
        return new ResponseEntity<>(service.Update(id, sedanCar), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteSedanCar(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
