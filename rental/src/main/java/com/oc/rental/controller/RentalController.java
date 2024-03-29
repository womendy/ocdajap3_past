package com.oc.rental.controller;

import com.oc.rental.models.Rental;
import com.oc.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class RentalController {
    private RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("rentals")
    public List<Rental> getAllRental(){
        return rentalService.getAllRental().get();
    }
    @GetMapping("rentals/{id}")
    public Rental getByid(@PathVariable("id") long id){
        return rentalService.getRentalById(id).orElseThrow();
    }
}
