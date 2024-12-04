package com.project.nasaweb.models;

import jakarta.persistence.*;
import lombok.*;

import com.project.nasaweb.models.Aproach;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ASTEROID")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asteroid {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "absolute_magnitude")
    private float absoluteMagnitude;
    @Column(name = "diameter_km_average")
    private float diameterKmAverage;
    @Column(name = "is_potentially_hazardous")
    private int isPotentiallyHazardous;
    @OneToMany(mappedBy = "asteroid", cascade = CascadeType.ALL)
    private List<Aproach> approaches;
}
