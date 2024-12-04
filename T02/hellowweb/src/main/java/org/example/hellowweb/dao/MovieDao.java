package org.example.hellowweb.dao;

import org.example.hellowweb.model.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> findAll();
    Movie findByID(Long id);
    boolean deleteByID(Long id);
    void update(Movie movie);
    Movie createMovie(Movie movie);
    boolean login(String name, String password);
    boolean createUser(String name, String password);
}
