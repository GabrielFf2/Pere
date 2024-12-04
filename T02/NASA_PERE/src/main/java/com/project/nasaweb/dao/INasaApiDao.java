package com.project.nasaweb.dao;

import com.project.nasaweb.model.Asteroid;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

public interface INasaApiDao {
    List<Asteroid> getAsteroids() throws URISyntaxException, IOException, InterruptedException, ParseException;
}
