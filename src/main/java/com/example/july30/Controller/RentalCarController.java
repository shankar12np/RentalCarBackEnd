package com.example.july30.Controller;

import com.example.july30.Entity.CarRental;
import com.example.july30.Service.RentalCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
@CrossOrigin ("http://localhost:4200")
public class RentalCarController {

    private final RentalCarService rentalCarService;

    @Autowired
    public RentalCarController(RentalCarService rentalCarService) {
        this.rentalCarService = rentalCarService;
    }

    @GetMapping
    public List<CarRental> getAllAvailableCars() {
        return rentalCarService.getAllAvailableCars();
    }

    @GetMapping("/{id}")
    public CarRental getCarById(@PathVariable Long id) {
        return rentalCarService.getCarById(id);
    }

    @PostMapping("/{id}/rent")
    public ResponseEntity<CarRental> rentCar(@PathVariable Long id) {
        CarRental rentedCar = rentalCarService.rentCar(id);
        if (rentedCar != null) {
            return ResponseEntity.ok(rentedCar); // Return 200 OK with the rented car as the response body
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the car is not available or does not exist
        }
    }


    @PostMapping("/{id}/return")
    public ResponseEntity<String> returnCar(@PathVariable Long id) {
        boolean carReturned = rentalCarService.returnCar(id);
        if (carReturned) {
            return ResponseEntity.ok("Car successfully returned."); // Return 200 OK with a success message
        } else {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the car is not found or not rented
        }
    }
}
