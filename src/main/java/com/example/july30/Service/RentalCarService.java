package com.example.july30.Service;

import com.example.july30.Entity.CarRental;
import com.example.july30.Repository.RentalCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalCarService {
    private final RentalCarRepository rentalCarRepository;
    @Autowired
    public RentalCarService(RentalCarRepository rentalCarRepository){
        this.rentalCarRepository = rentalCarRepository;
    }
    public List<CarRental> getAllAvailableCars(){
        return rentalCarRepository.findAllByAvailableTrue();
    }

    public CarRental getCarById(Long id){
        return rentalCarRepository.findById(id).orElse(null);
    }

    public CarRental rentCar(Long id) {
        CarRental carRental = rentalCarRepository.findById(id).orElse(null);
        if (carRental != null && carRental.isAvailable()) {
            carRental.setAvailable(false);
            rentalCarRepository.save(carRental);
            return carRental;
        }
        return null;
    }

    public boolean returnCar(Long id) {
        CarRental carRental = rentalCarRepository.findById(id).orElse(null);
        if (carRental != null && !carRental.isAvailable()) {
            carRental.setAvailable(true);
            rentalCarRepository.save(carRental);
        }
        return false;
    }
}