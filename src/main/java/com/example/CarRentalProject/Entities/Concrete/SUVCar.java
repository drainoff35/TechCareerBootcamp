package com.example.CarRentalProject.Entities.Concrete;

import com.example.CarRentalProject.Entities.Abstract.Car;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
@JsonTypeName("suv")
public class SUVCar extends Car {

    @Override
    public Double calculateMonthlyRentalPrice() {
        return null;
    }

    @Override
    public boolean isHatchbackOrSedan() {
        return false;
    }


}
