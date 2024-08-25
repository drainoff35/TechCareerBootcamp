package com.example.CarRentalProject.DTOs;

import com.example.CarRentalProject.Entities.Abstract.Car;
import com.example.CarRentalProject.Entities.Abstract.Customer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RentalRequestDto {
    private Long id;
    private Car car;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
}
