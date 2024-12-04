package com.project.nasaweb.dao;

import com.project.nasaweb.model.Aproach;

import java.util.List;

public interface IAproachDao extends ICrudDao <Aproach> {

    List<Aproach> getAproachByAsteroidID(Long asteroidID);

}
