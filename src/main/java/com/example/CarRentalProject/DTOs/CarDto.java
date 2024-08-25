package com.example.CarRentalProject.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CarDto {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String gearType;
    private String color;
    private Integer trunkCapacity;
    private String fuelType;
    private Double engineCapacity;
    private Double dailyRentalPrice;
}
