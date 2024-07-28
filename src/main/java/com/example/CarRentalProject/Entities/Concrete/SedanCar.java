package com.example.CarRentalProject.Entities.Concrete;

import com.example.CarRentalProject.Entities.Abstract.Car;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
@JsonTypeName("sedan")
public class SedanCar extends Car {
    private static final Double monthlyDiscountRate=10.0;

    @Override
    public Double calculateMonthlyRentalPrice() {
        Double monthlyPrice=getDailyRentalPrice()*30;
        return monthlyPrice - (monthlyPrice*monthlyDiscountRate/100);
    }

    @Override
    public boolean isHatchbackOrSedan() {
        return true;
    }
}
