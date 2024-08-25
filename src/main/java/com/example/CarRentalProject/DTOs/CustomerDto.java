package com.example.CarRentalProject.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CustomerDto {
    private Long id;
    private String name;
    private String phoneNumber;
}
