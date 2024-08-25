package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.DTOs.SedanCarRequestDto;
import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Entities.Concrete.IndividualCustomer;
import com.example.CarRentalProject.Entities.Concrete.SedanCar;
import com.example.CarRentalProject.Repositories.RentalRepository;
import com.example.CarRentalProject.Repositories.SedanCarRepository;
import com.example.CarRentalProject.Services.Abstract.ISedanCarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SedanCarService implements ISedanCarService {
    private final SedanCarRepository sedanCarRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<SedanCarRequestDto> GetAll() {
        return sedanCarRepository.findAll().stream()
                .map(car -> modelMapper.map(car, SedanCarRequestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SedanCarRequestDto GetById(Long aLong) {
        SedanCar car= sedanCarRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Car not found:"+aLong));
        return modelMapper.map(car, SedanCarRequestDto.class);
    }

    @Override
    public Boolean Create(SedanCarRequestDto dto) {
        SedanCar car = modelMapper.map(dto, SedanCar.class);
        sedanCarRepository.save(car);
        return true;
    }

    @Override
    public Boolean Update(Long aLong, SedanCarRequestDto car) {
        SedanCar temp=sedanCarRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Car not found with id:"+aLong));
        if (temp!=null){
            temp.setDailyRentalPrice(car.getDailyRentalPrice());
        }
        sedanCarRepository.save(temp);
        return true;

    }

    @Override
    public Void Delete(Long aLong) {
    sedanCarRepository.deleteById(aLong);
    return null;
    }
}
