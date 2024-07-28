package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Entities.Concrete.SedanCar;
import com.example.CarRentalProject.Repositories.RentalRepository;
import com.example.CarRentalProject.Repositories.SedanCarRepository;
import com.example.CarRentalProject.Services.Abstract.ISedanCarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SedanCarService implements ISedanCarService {
    private final SedanCarRepository sedanCarRepository;


    @Override
    public List<SedanCar> GetAll() {
        return sedanCarRepository.findAll();
    }

    @Override
    public Optional<SedanCar> GetById(Long aLong) {
        return sedanCarRepository.findById(aLong);
    }

    @Override
    public SedanCar Create(SedanCar sedanCar) {
        return sedanCarRepository.save(sedanCar);
    }

    @Override
    public SedanCar Update(Long aLong, SedanCar sedanCar) {
        SedanCar temp=sedanCarRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Car not found with id:"+aLong));
        if (temp!=null){
            temp.setDailyRentalPrice(sedanCar.getDailyRentalPrice());
        }
        return sedanCarRepository.save(temp);
    }

    @Override
    public void Delete(Long aLong) {
    sedanCarRepository.deleteById(aLong);
    }
}
