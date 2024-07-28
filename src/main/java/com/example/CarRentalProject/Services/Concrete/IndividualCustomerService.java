package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.Entities.Concrete.IndividualCustomer;
import com.example.CarRentalProject.Repositories.IndividualCustomerRepository;
import com.example.CarRentalProject.Services.Abstract.IIndividualCustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IndividualCustomerService implements IIndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;


    @Override
    public List<IndividualCustomer> GetAll() {
        return individualCustomerRepository.findAll();
    }

    @Override
    public Optional<IndividualCustomer> GetById(Long aLong) {
        return individualCustomerRepository.findById(aLong);
    }

    @Override
    public IndividualCustomer Create(IndividualCustomer individualCustomer) {
        return individualCustomerRepository.save(individualCustomer);
    }

    @Override
    public IndividualCustomer Update(Long aLong, IndividualCustomer individualCustomer) {
        IndividualCustomer temp=individualCustomerRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Customer not found with id:"+aLong));
        if (temp!=null){
            temp.setName(individualCustomer.getName());
            temp.setPhoneNumber(individualCustomer.getPhoneNumber());
            temp.setIdentityNo(individualCustomer.getIdentityNo());
        }
        return individualCustomerRepository.save(individualCustomer);
    }

    @Override
    public void Delete(Long aLong) {
        individualCustomerRepository.deleteById(aLong);
    }
}
