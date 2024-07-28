package com.example.CarRentalProject.Services.Concrete;

import com.example.CarRentalProject.Entities.Concrete.CorporateCustomer;
import com.example.CarRentalProject.Repositories.CorporateCustomerRepository;
import com.example.CarRentalProject.Services.Abstract.ICorporateCustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CorporateCustomerService implements ICorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;


    @Override
    public List<CorporateCustomer> GetAll() {
        return corporateCustomerRepository.findAll();
    }

    @Override
    public Optional<CorporateCustomer> GetById(Long aLong) {
        return corporateCustomerRepository.findById(aLong);
    }

    @Override
    public CorporateCustomer Create(CorporateCustomer corporateCustomer) {
        return corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public CorporateCustomer Update(Long aLong, CorporateCustomer corporateCustomer) {
        CorporateCustomer temp=corporateCustomerRepository.findById(aLong).orElseThrow(()-> new EntityNotFoundException("Customer not found with id:"+ aLong));
        if (temp!=null){
            temp.setName(corporateCustomer.getName());
            temp.setTaxNo(corporateCustomer.getTaxNo());
            temp.setPhoneNumber(corporateCustomer.getPhoneNumber());
        }
        return corporateCustomerRepository.save(corporateCustomer);
    }

    @Override
    public void Delete(Long aLong) {
    corporateCustomerRepository.deleteById(aLong);
    }
}
