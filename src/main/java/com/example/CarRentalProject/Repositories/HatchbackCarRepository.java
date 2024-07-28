package com.example.CarRentalProject.Repositories;

import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HatchbackCarRepository extends JpaRepository<HatchbackCar,Long> {
}
