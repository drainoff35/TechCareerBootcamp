package com.example.CarRentalProject.Services.Abstract;

import com.example.CarRentalProject.DTOs.IndividualCustomerRequestDto;

import org.springframework.stereotype.Service;

@Service
public interface IIndividualCustomerService extends BaseService<IndividualCustomerRequestDto,Long> {
}
