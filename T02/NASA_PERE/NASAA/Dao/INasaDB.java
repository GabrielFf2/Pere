package com.project.nasaweb.Dao;

import com.project.nasaweb.models.Aproach;
import com.project.nasaweb.models.Asteroid;

import java.util.List;

public interface INasaDB {
    //Asteroid
    List<Asteroid> getAllAsteroids();
    Asteroid getAsteroidById(int id);
    String updateAsteroid(Asteroid asteroid);
    String deleteAsteroidById(long id);
    String insertAsteroid(Asteroid asteroid);
    String insertAsteroids(List<Asteroid> asteroids);

    //Aproach
    List<Aproach> getAllAproaches(int asteroidId);
    Aproach getAproachById(int aproachId);
    void updateAproach(Aproach aproach);
    void insertAproach(Aproach aproach);
    void insertAproaches(List<Aproach> aproaches);
    String deleteAproachById(long aproachId);
}

