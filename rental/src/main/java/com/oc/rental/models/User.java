package com.oc.rental.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User extends CoreEntity {

    @Column(nullable = false)
    private String email;
    @OneToMany(mappedBy = "owner")
    private List<Rental> rentalList;
}
