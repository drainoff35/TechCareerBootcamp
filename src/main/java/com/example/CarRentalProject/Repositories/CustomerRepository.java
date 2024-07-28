package com.example.CarRentalProject.Repositories;

import com.example.CarRentalProject.Entities.Abstract.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
