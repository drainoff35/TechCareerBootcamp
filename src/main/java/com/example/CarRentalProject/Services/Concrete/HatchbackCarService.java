package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Repositories.HatchbackCarRepository;
import com.example.CarRentalProject.Services.Abstract.IHatchbackCarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HatchbackCarService implements IHatchbackCarService {
    private final HatchbackCarRepository hatchbackCarRepository;


    @Override
    public List<HatchbackCar> GetAll() {
        return hatchbackCarRepository.findAll();
    }

    @Override
    public Optional<HatchbackCar> GetById(Long aLong) {
        return hatchbackCarRepository.findById(aLong);
    }

    @Override
    public HatchbackCar Create(HatchbackCar hatchbackCar) {
        return hatchbackCarRepository.save(hatchbackCar);
    }

    @Override
    public HatchbackCar Update(Long aLong, HatchbackCar hatchbackCar) {
        HatchbackCar temp=hatchbackCarRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Car not found with id:"+aLong));
        if (temp!=null){
            temp.setDailyRentalPrice(hatchbackCar.getDailyRentalPrice());
        }
        return hatchbackCarRepository.save(temp);
    }

    @Override
    public void Delete(Long aLong) {
        hatchbackCarRepository.deleteById(aLong);
    }
}
