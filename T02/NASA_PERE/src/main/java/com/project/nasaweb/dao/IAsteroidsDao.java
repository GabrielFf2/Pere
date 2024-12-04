package com.project.nasaweb.dao;

import com.project.nasaweb.model.Asteroid;

public interface IAsteroidsDao extends ICrudDao<Asteroid> {

    void deleteAsteroid(Long id);
    void updateAsteroid(Asteroid asteroid);

}
