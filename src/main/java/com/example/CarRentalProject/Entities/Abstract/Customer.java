package com.example.CarRentalProject.Entities.Abstract;

import com.example.CarRentalProject.Entities.Concrete.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CorporateCustomer.class, name = "corporate"),
        @JsonSubTypes.Type(value = IndividualCustomer.class, name = "individual")
})

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "customer-rental")
    private List<Rental> rentals;

    public abstract boolean isIndividual();
}
