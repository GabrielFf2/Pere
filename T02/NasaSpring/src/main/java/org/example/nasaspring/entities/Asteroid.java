package org.example.nasaspring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asteroids")
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

    public Asteroid(String name, float absoluteMagnitude, float diameterKmAverage, int isPotentiallyHazardous) {
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.diameterKmAverage = diameterKmAverage;
        this.isPotentiallyHazardous = isPotentiallyHazardous;
    }

}