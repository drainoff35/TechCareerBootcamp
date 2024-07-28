package com.example.CarRentalProject.Controllers;

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
    public ResponseEntity<List<HatchbackCar>> GetAllHatchbackCar() {
        return new ResponseEntity<>(service.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<HatchbackCar> GetHatchbackCarById(@PathVariable long id) {
        return service.GetById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<HatchbackCar> CreateHatchbackCar(@RequestBody HatchbackCar hatchbackCar) {
        return new ResponseEntity<>(service.Create(hatchbackCar), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HatchbackCar> UpdateHatchbackCar(@PathVariable long id, @RequestBody HatchbackCar hatchbackCar) {
        return new ResponseEntity<>(service.Update(id, hatchbackCar), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteHatchbackCar(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
