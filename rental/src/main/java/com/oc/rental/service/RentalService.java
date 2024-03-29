package com.oc.rental.service;

import com.oc.rental.models.Rental;

import java.util.List;
import java.util.Optional;

public interface RentalService {

    public Optional<Rental> getRentalById(long id);
    public Optional<List<Rental>> getAllRental();
}
