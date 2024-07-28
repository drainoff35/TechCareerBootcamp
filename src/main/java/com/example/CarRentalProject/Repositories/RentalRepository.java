package com.example.CarRentalProject.Repositories;

import com.example.CarRentalProject.Entities.Concrete.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long> {
}
