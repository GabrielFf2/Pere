package org.example.nasaspring.repository;

import org.example.nasaspring.entities.Asteroid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IAsteroidRepo extends JpaRepository<Asteroid, Long> {
    Asteroid findAsteroidById(Long id);
    Asteroid saveAsteroid(Asteroid asteroid);
    Boolean deleteAsteroid(Long id);
    Asteroid updateAsteroid(Asteroid asteroid);
}
