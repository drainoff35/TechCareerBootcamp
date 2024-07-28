package com.example.CarRentalProject.Entities.Concrete;

import com.example.CarRentalProject.Entities.Abstract.Customer;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
@JsonTypeName("individual")
public class IndividualCustomer extends Customer {
    private Long IdentityNo;

    @Override
    public boolean isIndividual() {
        return true;
    }
}
