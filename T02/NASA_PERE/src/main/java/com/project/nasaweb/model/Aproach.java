package com.project.nasaweb.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Aproach")

public class Aproach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "data")
    private Date data;
    @Column(name = "velocity")
    private double velocity;
    @Column(name = "distance")
    private double distance;
    @Column(name = "orbiting_body")
    private String orbiting_body;
    @ManyToOne
    @JoinColumn(name = "ID_Asteroid",referencedColumnName = "id")
    private Asteroid asteroid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getOrbiting_body() {
        return orbiting_body;
    }

    public void setOrbiting_body(String orbiting_body) {
        this.orbiting_body = orbiting_body;
    }

    public Asteroid getAsteroid() {
        return asteroid;
    }

    public void setAsteroid(Asteroid asteroid) {
        this.asteroid = asteroid;
    }

    public Aproach(Long id, Date data, double velocity, double distance, String orbiting_body, Asteroid asteroid) {
        this.id = id;
        this.data = data;
        this.velocity = velocity;
        this.distance = distance;
        this.orbiting_body = orbiting_body;
        this.asteroid = asteroid;
    }
}
