package com.example.july30.Repository;

import com.example.july30.Entity.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalCarRepository extends JpaRepository <CarRental, Long> {
    List<CarRental> findAllByAvailableTrue();
}
