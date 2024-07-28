package com.example.CarRentalProject.Entities.Abstract;

import com.example.CarRentalProject.Entities.Concrete.HatchbackCar;
import com.example.CarRentalProject.Entities.Concrete.Rental;
import com.example.CarRentalProject.Entities.Concrete.SUVCar;
import com.example.CarRentalProject.Entities.Concrete.SedanCar;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.nio.DoubleBuffer;
import java.text.DecimalFormat;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = HatchbackCar.class, name = "hatchback"),
        @JsonSubTypes.Type(value = SedanCar.class, name = "sedan"),
        @JsonSubTypes.Type(value = SUVCar.class, name = "suv")
})

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String gearType;
    private String color;
    private Integer trunkCapacity;
    private String fuelType;
    private Double engineCapacity;
    private Double dailyRentalPrice;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "car-rental")
    private List<Rental> rentals;

    public abstract Double calculateMonthlyRentalPrice();
    public abstract boolean isHatchbackOrSedan();

}
