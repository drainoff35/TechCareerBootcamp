package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.DTOs.SUVCarRequestDto;
import com.example.CarRentalProject.DTOs.SedanCarRequestDto;
import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Entities.Concrete.SUVCar;
import com.example.CarRentalProject.Entities.Concrete.SedanCar;
import com.example.CarRentalProject.Repositories.SUVCarRepository;
import com.example.CarRentalProject.Services.Abstract.ISUVCarService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Subgraph;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SUVCarService implements ISUVCarService {
    private final SUVCarRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<SUVCarRequestDto> GetAll() {
        return repository.findAll().stream()
                .map(car -> modelMapper.map(car, SUVCarRequestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SUVCarRequestDto GetById(Long aLong) {
        SUVCar car= repository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Car not found:"+aLong));
        return modelMapper.map(car, SUVCarRequestDto.class);
    }

    @Override
    public Boolean Create(SUVCarRequestDto dto) {
        SUVCar car = modelMapper.map(dto, SUVCar.class);
        repository.save(car);
        return true;
    }

    @Override
    public Boolean Update(Long aLong, SUVCarRequestDto dto) {
        SUVCar temp=repository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Car not found with id:"+aLong));
        if (temp!=null){

            temp.setDailyRentalPrice(dto.getDailyRentalPrice());
        }
        repository.save(temp);
        return true;
    }

    @Override
    public Void Delete(Long aLong) {
    repository.deleteById(aLong);
    return null;
    }
}
