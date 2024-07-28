package com.example.CarRentalProject.Entities.Concrete;

import com.example.CarRentalProject.Entities.Abstract.Car;
import com.example.CarRentalProject.Entities.Abstract.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Data
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @JsonBackReference(value = "car-rental")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference(value = "customer-rental")
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalCost;


    public void calculateTotalCost() {
        if (car == null) {
            throw new RuntimeException("Car information is not set.");
        }

        if (car.getDailyRentalPrice() == null) {
            throw new RuntimeException("Daily rental price is not set for the car.");
        }

        long days = ChronoUnit.DAYS.between(startDate, endDate);

        if (car.isHatchbackOrSedan()) {
            Double monthlyPrice = car.calculateMonthlyRentalPrice();
            if (monthlyPrice == null) {
                throw new RuntimeException("Monthly rental price is not set for the car.");
            }
            long months= days/30;
            long remainingDays = days % 30;
            totalCost =(monthlyPrice*months)+(remainingDays*car.getDailyRentalPrice());
        } else {
            totalCost = days * car.getDailyRentalPrice();
        }
    }
}
