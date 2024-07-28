package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.Entities.Abstract.Car;
import com.example.CarRentalProject.Entities.Abstract.Customer;
import com.example.CarRentalProject.Entities.Concrete.Rental;
import com.example.CarRentalProject.Entities.Concrete.SUVCar;
import com.example.CarRentalProject.Repositories.CarRepository;
import com.example.CarRentalProject.Repositories.CustomerRepository;
import com.example.CarRentalProject.Repositories.RentalRepository;
import com.example.CarRentalProject.Services.Abstract.IRentalService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalService implements IRentalService {
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;


    @Override
    public List<Rental> GetAll() {
        return rentalRepository.findAll();
    }

    @Override
    public Optional<Rental> GetById(Long aLong) {
        return rentalRepository.findById(aLong);
    }

    @Override
    public Rental Create(Rental rental) {
        Car car = carRepository.findById(rental.getCar().getId()).orElseThrow(() -> new RuntimeException("Car not found"));
        Customer customer = customerRepository.findById(rental.getCustomer().getId()).orElseThrow(() -> new RuntimeException("Customer not found"));

        rental.setCar(car);
        rental.setCustomer(customer);
        if (!rental.getCar().isHatchbackOrSedan()){
            long days=ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
            if (days>30){
                 throw new RuntimeException("SUV's only can rent daily.");
            }
        }
        rental.calculateTotalCost();
        return rentalRepository.save(rental);
    }


    @Override
    public Rental Update(Long aLong, Rental rental) {
        Rental temp=rentalRepository.findById(aLong).orElseThrow(()->new EntityNotFoundException("Rental not found with id:"+aLong));
        Car car=carRepository.findById(temp.getCar().getId()).orElseThrow(()->new EntityNotFoundException("Car not found with id:"+aLong));
        Customer customer = customerRepository.findById(temp.getCustomer().getId()).orElseThrow(
                ()->new EntityNotFoundException("Customer not found with id:"+aLong)
        );

        rental.setCar(car);
        rental.setCustomer(customer);
        long daysBetween = ChronoUnit.DAYS.between(rental.getStartDate(),rental.getEndDate());

        if (customer.isIndividual() && !car.isHatchbackOrSedan()){
            throw new RuntimeException("Individual customers can only rent Hatchback and Sedan cars.");
        }

        if (!car.isHatchbackOrSedan() && daysBetween >= 30) {
            throw new RuntimeException("SUV cars can only be rented on a daily basis.");
        }


        if(temp!=null){
            temp.setEndDate(rental.getEndDate());
            temp.setStartDate(rental.getStartDate());
            temp.calculateTotalCost();
        }

        return rentalRepository.save(temp);
    }

    @Override
    public void Delete(Long aLong) {
    rentalRepository.deleteById(aLong);
    }
}
