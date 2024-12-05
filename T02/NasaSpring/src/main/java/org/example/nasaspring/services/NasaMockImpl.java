package org.example.nasaspring.services;

import jakarta.annotation.PostConstruct;
import org.example.nasaspring.entities.Asteroid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NasaMockImpl implements INasa {

    List<Asteroid> asteroids = new ArrayList<>();

    @Override
    public List<Asteroid> asteroids() {
        return asteroids;
    }

    @Override
    public Asteroid findAsteroidById(Long id) {
        return asteroids.stream().filter(asteroid -> asteroid.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Asteroid saveAsteroid(Asteroid asteroid) {
        asteroid.setId((long) (asteroids.size() + 1));
        asteroids.add(asteroid);
        return asteroid;
    }

    @Override
    public boolean deleteAsteroid(Long id) {
        return asteroids.removeIf(asteroid -> asteroid.getId() == id);
    }

    @Override
    public Asteroid updateAsteroid(Asteroid asteroid) {
        Asteroid found = findAsteroidById(asteroid.getId());
        found.setName(asteroid.getName());
        found.setAbsoluteMagnitude(asteroid.getAbsoluteMagnitude());
        found.setDiameterKmAverage(asteroid.getDiameterKmAverage());
        found.setIsPotentiallyHazardous(asteroid.getIsPotentiallyHazardous());
        return found;
    }

    @PostConstruct
    public void init() {
        asteroids.add(new Asteroid(1L, "Asteroid 1", 1.1f, 1.1f, 1));
        asteroids.add(new Asteroid(2L, "Asteroid 2", 2.2f, 2.2f, 0));
        asteroids.add(new Asteroid(3L, "Asteroid 3", 3.3f, 3.3f, 1));
    }
}
