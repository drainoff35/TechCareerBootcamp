package com.example.CarRentalProject.Repositories;

import com.example.CarRentalProject.Entities.Concrete.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer,Long> {
}
