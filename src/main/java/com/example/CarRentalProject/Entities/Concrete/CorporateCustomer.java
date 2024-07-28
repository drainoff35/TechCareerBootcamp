package com.example.CarRentalProject.Entities.Concrete;

import com.example.CarRentalProject.Entities.Abstract.Customer;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@JsonTypeName("corporate")
public class CorporateCustomer extends Customer {
    private Long taxNo;

    @Override
    public boolean isIndividual() {
        return false;
    }
}
