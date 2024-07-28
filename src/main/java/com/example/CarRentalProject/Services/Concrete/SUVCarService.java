package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Entities.Concrete.SUVCar;
import com.example.CarRentalProject.Repositories.SUVCarRepository;
import com.example.CarRentalProject.Services.Abstract.ISUVCarService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Subgraph;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SUVCarService implements ISUVCarService {
    private final SUVCarRepository repository;

    @Override
    public List<SUVCar> GetAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SUVCar> GetById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public SUVCar Create(SUVCar suvCar) {
        return repository.save(suvCar);
    }

    @Override
    public SUVCar Update(Long aLong, SUVCar suvCar) {
        SUVCar temp=repository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Car not found with id:"+aLong));
        if (temp!=null){

            temp.setDailyRentalPrice(suvCar.getDailyRentalPrice());
        }
        return repository.save(temp);
    }

    @Override
    public void Delete(Long aLong) {
    repository.deleteById(aLong);
    }
}
