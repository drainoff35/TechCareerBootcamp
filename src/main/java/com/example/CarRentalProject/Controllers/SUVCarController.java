package com.example.CarRentalProject.Controllers;

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
    public ResponseEntity<List<SUVCar>> GetAllSUVCar() {
        return new ResponseEntity<>(service.GetAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<SUVCar> GetSUVCarById(@PathVariable long id) {
        return service.GetById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<SUVCar> CreateSUVCar(@RequestBody SUVCar suvCar) {
        return new ResponseEntity<>(service.Create(suvCar), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SUVCar> UpdateSUVCar(@PathVariable long id, @RequestBody SUVCar suvCar) {
        return new ResponseEntity<>(service.Update(id, suvCar), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteSUVCar(@PathVariable long id) {
        service.Delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
