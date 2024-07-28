package com.example.CarRentalProject.Repositories;

import com.example.CarRentalProject.Entities.Concrete.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Long> {
}
