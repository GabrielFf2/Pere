package com.project.nasaweb.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "APPROACH")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aproach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_asteroid", referencedColumnName = "id")
    private Asteroid asteroid;
    @Column(name = "approach_date")
    private Date aproachDate;
    @Column(name = "velocity")
    private float velocity;
    @Column(name = "distance")
    private float distance;
    @Column(name = "orbiting_body")
    private String orbitingBody;
}


