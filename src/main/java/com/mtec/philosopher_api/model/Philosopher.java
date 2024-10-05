package com.mtec.philosopher_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Philosopher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String philosophicalCurrent;

    public Philosopher() {
    }

    public Philosopher(Long id, String name, String country, String philosophicalCurrent) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.philosophicalCurrent = philosophicalCurrent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhilosophicalCurrent() {
        return philosophicalCurrent;
    }

    public void setPhilosophicalCurrent(String philosophicalCurrent) {
        this.philosophicalCurrent = philosophicalCurrent;
    }
}