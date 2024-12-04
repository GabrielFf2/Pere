package org.example.nasaspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asteroid {
    private Long id;
    private String name;
    private float absoluteMagnitude;
    private float diameterKmAverage;
    private int isPotentiallyHazardous;

    public Asteroid(String name, float absoluteMagnitude, float diameterKmAverage, int isPotentiallyHazardous) {
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.diameterKmAverage = diameterKmAverage;
        this.isPotentiallyHazardous = isPotentiallyHazardous;
    }
}