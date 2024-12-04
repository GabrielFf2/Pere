package com.project.nasaweb.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Asteroid")
public class Asteroid {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "magnitude")
    private double magnitude;
    @Column(name = "diameter")
    private double diameter;
    @Column(name = "isDangerous")
    private boolean isDangerous;
    @OneToMany(mappedBy = "asteroid" , cascade = CascadeType.ALL)
    private List<Aproach> aproach;

    public Asteroid(Long id, String name, double magnitude, double diameter, boolean isDangerous) {
        this.id = id;
        this.name = name;
        this.magnitude = magnitude;
        this.diameter = diameter;
        this.isDangerous = isDangerous;
    }
}
