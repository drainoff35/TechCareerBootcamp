package com.example.CarRentalProject.Repositories;

import com.example.CarRentalProject.Entities.Concrete.SedanCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedanCarRepository extends JpaRepository<SedanCar,Long> {
}
