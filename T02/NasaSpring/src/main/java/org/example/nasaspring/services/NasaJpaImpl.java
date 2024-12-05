package org.example.nasaspring.services;

import org.example.nasaspring.entities.Asteroid;
import org.example.nasaspring.repository.IAsteroidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("NasaJpaImpl")
public class NasaJpaImpl implements INasa {
    
    @Autowired
    IAsteroidRepo asteroidRepo;
    
    public NasaJpaImpl() {
    }

    public List<Asteroid> asteroids() {
        return asteroidRepo.findAll();
    }

    public Asteroid findAsteroidById(Long id) {
        return asteroidRepo.findAsteroidById(id);
    }

    public Asteroid saveAsteroid(Asteroid asteroid) {
        return asteroidRepo.saveAsteroid(asteroid);
    }

    public boolean deleteAsteroid(Long id) {
        return asteroidRepo.deleteAsteroid(id);
    }

    public Asteroid updateAsteroid(Asteroid asteroid) {
        return asteroidRepo.updateAsteroid(asteroid);
    }
}
