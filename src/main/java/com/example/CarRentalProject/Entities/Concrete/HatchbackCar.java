package com.example.CarRentalProject.Entities.Concrete;

import com.example.CarRentalProject.Entities.Abstract.Car;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
@JsonTypeName("hatchback")
public class HatchbackCar extends Car {
    private static final Double monthlyDiscountRate=6.0;

    @Override
    public Double calculateMonthlyRentalPrice() {
        Double dailyPrice=getDailyRentalPrice();
        if (dailyPrice == null) {
            throw new RuntimeException("Daily rental price is not set for the hatchback car.");
        }

        double monthlyPrice= getDailyRentalPrice()*30;
        return monthlyPrice - (monthlyPrice * monthlyDiscountRate / 100);
    }

    @Override
    public boolean isHatchbackOrSedan() {
        return true;
    }
}
