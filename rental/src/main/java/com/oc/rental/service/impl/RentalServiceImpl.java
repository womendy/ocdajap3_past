package com.oc.rental.service.impl;

import com.oc.rental.models.Rental;
import com.oc.rental.repository.impl.RentalRepository;
import com.oc.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService {
    private RentalRepository rentalRepository;

    @Autowired
    public RentalServiceImpl (RentalRepository rentalRepository){
        this.rentalRepository = rentalRepository;
    }
    @Override
    public Optional<Rental> getRentalById(long id) {
        return rentalRepository.findById(id);
    }

    @Override
    public Optional<List<Rental>> getAllRental() {
        List<Rental> rentals = new ArrayList<>();
        rentalRepository.findAll().forEach(rentals::add);
        return Optional.of(rentals);
    }
}
