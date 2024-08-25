package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.DTOs.HatchbackCarRequestDto;
import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Repositories.HatchbackCarRepository;
import com.example.CarRentalProject.Services.Abstract.IHatchbackCarService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HatchbackCarService implements IHatchbackCarService {
    private final HatchbackCarRepository hatchbackCarRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<HatchbackCarRequestDto> GetAll() {
        return hatchbackCarRepository.findAll().stream()
                .map(car -> modelMapper.map(car,HatchbackCarRequestDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public HatchbackCarRequestDto GetById(Long aLong) {
    HatchbackCar car = hatchbackCarRepository.findById(aLong).orElseThrow(()->new EntityNotFoundException("Car Not Found:"+aLong));
    return modelMapper.map(car,HatchbackCarRequestDto.class);
    }

    @Override
    public Boolean Create(HatchbackCarRequestDto dto) {
        HatchbackCar car = modelMapper.map(dto,HatchbackCar.class);
        hatchbackCarRepository.save(car);
        return true;
    }

    @Override
    public Boolean Update(Long aLong, HatchbackCarRequestDto dto) {
        HatchbackCar temp=hatchbackCarRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Car not found with id:"+aLong));
        if (temp!=null){
            temp.setDailyRentalPrice(dto.getDailyRentalPrice());
        }
        hatchbackCarRepository.save(temp);
        return true;
    }

    @Override
    public Void Delete(Long aLong) {
        hatchbackCarRepository.deleteById(aLong);
        return null;
    }
}
