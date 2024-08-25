package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.DTOs.IndividualCustomerRequestDto;
import com.example.CarRentalProject.Entities.Concrete.IndividualCustomer;
import com.example.CarRentalProject.Repositories.IndividualCustomerRepository;
import com.example.CarRentalProject.Services.Abstract.IIndividualCustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndividualCustomerService implements IIndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<IndividualCustomerRequestDto> GetAll() {
        return individualCustomerRepository.findAll().stream()
                .map(customer -> modelMapper.map(customer, IndividualCustomerRequestDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public IndividualCustomerRequestDto GetById(Long aLong) {
        IndividualCustomer customer=individualCustomerRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Individual Customer Not Found: " +aLong));
        return modelMapper.map(customer, IndividualCustomerRequestDto.class);
    }
    @Override
    public Boolean Create(IndividualCustomerRequestDto dto) {
        IndividualCustomer customer = modelMapper.map(dto, IndividualCustomer.class);
        individualCustomerRepository.save(customer);
        return true;
    }

    @Override
    public Boolean Update(Long aLong, IndividualCustomerRequestDto dto) {
        IndividualCustomer temp=individualCustomerRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Customer not found with id:"+aLong));
        if (temp!=null){
            temp.setName(dto.getName());
            temp.setPhoneNumber(dto.getPhoneNumber());
            temp.setIdentityNo(dto.getIdentityNo());
        }
        individualCustomerRepository.save(temp);
        return true;
    }

    @Override
    public Void Delete(Long aLong) {
        individualCustomerRepository.deleteById(aLong);
        return null;
    }
}
