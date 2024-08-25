package com.example.CarRentalProject.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorporateCustomerRequestDto extends CustomerDto {
    private Long taxNo;
}
