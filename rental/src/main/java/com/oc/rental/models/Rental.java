package com.oc.rental.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
public class Rental extends CoreEntity {
    @Column(nullable = false)
    private float surface;
    @Column(nullable = false)
    private float price;
    @OneToMany(mappedBy = "rental")
    private List<Picture> picture;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    private User owner;
}
