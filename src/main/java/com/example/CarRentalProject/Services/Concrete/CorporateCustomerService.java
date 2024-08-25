package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.DTOs.CarDto;
import com.example.CarRentalProject.DTOs.CorporateCustomerRequestDto;
import com.example.CarRentalProject.DTOs.CustomerDto;
import com.example.CarRentalProject.Entities.Concrete.CorporateCustomer;
import com.example.CarRentalProject.Repositories.CorporateCustomerRepository;
import com.example.CarRentalProject.Services.Abstract.ICorporateCustomerService;
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
public class CorporateCustomerService implements ICorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<CorporateCustomerRequestDto> GetAll() {
        return corporateCustomerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, CorporateCustomerRequestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CorporateCustomerRequestDto GetById(Long aLong) {
        CorporateCustomer customer = corporateCustomerRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Customer not found with id: "+aLong));
        return modelMapper.map(customer, CorporateCustomerRequestDto.class);
    }

    @Override
    public Boolean Create(CorporateCustomerRequestDto dto) {
        CorporateCustomer customer = modelMapper.map(dto, CorporateCustomer.class);
        corporateCustomerRepository.save(customer);
        return true;

    }

    @Override
    public Boolean Update(Long aLong, CorporateCustomerRequestDto dto) {
        CorporateCustomer temp=corporateCustomerRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Customer not found with id:"+ aLong));
        if (temp!=null){
            temp.setPhoneNumber(dto.getPhoneNumber());
            temp.setTaxNo(dto.getTaxNo());
            temp.setName(dto.getName());
        }
        corporateCustomerRepository.save(temp);
        return true;

    }

    @Override
    public Void Delete(Long aLong) {
    corporateCustomerRepository.deleteById(aLong);
    return null;
    }
}
