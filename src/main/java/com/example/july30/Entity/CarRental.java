package com.example.july30.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Rental_Car")
public class CarRental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String make;
    private String model;
    private Integer year;
    private Boolean available;

    // Getter for availability
    public boolean isAvailable() {
        return available;
    }

    // Setter for availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

}
