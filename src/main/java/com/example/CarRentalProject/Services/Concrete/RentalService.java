package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.DTOs.RentalRequestDto;
import com.example.CarRentalProject.DTOs.SedanCarRequestDto;
import com.example.CarRentalProject.Entities.Abstract.Car;
import com.example.CarRentalProject.Entities.Abstract.Customer;
import com.example.CarRentalProject.Entities.Concrete.Rental;
import com.example.CarRentalProject.Entities.Concrete.SUVCar;
import com.example.CarRentalProject.Entities.Concrete.SedanCar;
import com.example.CarRentalProject.Repositories.CarRepository;
import com.example.CarRentalProject.Repositories.CustomerRepository;
import com.example.CarRentalProject.Repositories.RentalRepository;
import com.example.CarRentalProject.Services.Abstract.IRentalService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalService implements IRentalService {
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<RentalRequestDto> GetAll() {
        return rentalRepository.findAll().stream()
                .map(rental -> modelMapper.map(rental, RentalRequestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RentalRequestDto GetById(Long aLong) {
        Rental rental= rentalRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Rental not found:"+aLong));
        return modelMapper.map(rental, RentalRequestDto.class);
    }

    @Override
    public Boolean Create(RentalRequestDto dto) {
        Car car = carRepository.findById(dto.getCar().getId()).orElseThrow(() -> new RuntimeException("Car not found"));
        Customer customer = customerRepository.findById(dto.getCustomer().getId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        long days=ChronoUnit.DAYS.between(dto.getStartDate(), dto.getEndDate());
        dto.setCar(car);
        dto.setCustomer(customer);

        if (customer.isIndividual() && !car.isHatchbackOrSedan()){
            throw new RuntimeException("Individual customers can't rent Suv");
        }

        if (!car.isHatchbackOrSedan() && days >= 30) {
            throw new RuntimeException("SUV cars can only rent daily.");
        }

        if (!dto.getCar().isHatchbackOrSedan()){
            if (days>30){
                 throw new RuntimeException("SUV's only can rent daily.");
            }
        }

        Rental rental = new Rental();
        rental.setCar(dto.getCar());
        rental.setCustomer(dto.getCustomer());
        rental.setStartDate(dto.getStartDate());
        rental.setEndDate(dto.getEndDate());
        rental.calculateTotalCost();
        rentalRepository.save(rental);
        return true;
    }


    @Override
    public Boolean Update(Long aLong, RentalRequestDto dto) {
        Rental temp=rentalRepository.findById(aLong).orElseThrow(()->new EntityNotFoundException("Rental not found with id:"+aLong));

        if(temp!=null){
            temp.setStartDate(dto.getStartDate());
            temp.setEndDate(dto.getEndDate());
            temp.calculateTotalCost();
        }

        rentalRepository.save(temp);
        return true;
    }

    @Override
    public Void Delete(Long aLong) {
    rentalRepository.deleteById(aLong);
    return null;
    }
}
