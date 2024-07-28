package com.example.CarRentalProject.Repositories;

import com.example.CarRentalProject.Entities.Concrete.SUVCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SUVCarRepository extends JpaRepository<SUVCar,Long> {
}
