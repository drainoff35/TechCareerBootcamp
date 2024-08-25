package com.example.CarRentalProject.Services.Abstract;

import com.example.CarRentalProject.DTOs.CorporateCustomerRequestDto;
import com.example.CarRentalProject.Entities.Concrete.CorporateCustomer;
import org.springframework.stereotype.Service;


public interface ICorporateCustomerService extends BaseService<CorporateCustomerRequestDto,Long> {
}
