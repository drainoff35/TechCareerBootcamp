package com.example.CarRentalProject.Repositories;

import com.example.CarRentalProject.Entities.Abstract.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
