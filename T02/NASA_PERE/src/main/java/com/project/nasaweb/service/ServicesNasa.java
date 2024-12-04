package com.project.nasaweb.service;

import com.project.nasaweb.dao.AproachDaoImpl;
import com.project.nasaweb.dao.AsteroidsDaoImpl;
import com.project.nasaweb.model.Aproach;
import com.project.nasaweb.model.Asteroid;

import java.util.List;

public class ServicesNasa {

    AsteroidsDaoImpl asteroidsDao = new AsteroidsDaoImpl();
    AproachDaoImpl aproachDao = new AproachDaoImpl();

    public List<Asteroid> getAsteroids() {
        return asteroidsDao.findAll();
    }

    public void updateAsteroid(Asteroid asteroid) {
        asteroidsDao.save(asteroid);
    }

    public void deleteAsteroid(Long id) {
        asteroidsDao.deleteAsteroid(id);
    }

    public void saveAsteroid(Asteroid asteroid) {
        asteroidsDao.save(asteroid);
    }

    public void saveAsteroids(List<Asteroid> asteroids) {
        asteroidsDao.saveAll(asteroids);
    }

    public List<Aproach> getAproaches(long asteroidId) {
        return aproachDao.getAproachByAsteroidID(asteroidId);
    }

    public void updateAproach(Aproach aproach) {
        aproachDao.save(aproach);
    }

    public void deleteAproach(Aproach aproach) {
        aproachDao.save(aproach);
    }

    public void saveAproach(Aproach aproach) {
        aproachDao.save(aproach);
    }




}
