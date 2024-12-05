package org.example.nasaspring.services;

import org.example.nasaspring.entities.Asteroid;

import java.util.List;

public interface INasa {

    List<Asteroid> asteroids();
    Asteroid findAsteroidById(Long id);
    Asteroid saveAsteroid(Asteroid asteroid);
    boolean deleteAsteroid(Long id);
    Asteroid updateAsteroid(Asteroid asteroid);
}
