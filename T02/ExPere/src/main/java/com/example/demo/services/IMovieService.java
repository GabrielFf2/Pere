package com.example.demo.services;

import com.example.demo.entities.Movie;

import java.util.List;

public interface IMovieService {
    Movie add(Movie movie);
    List<Movie> findAll();
    Movie findOne(long id);
    Movie update(Movie movie);
}
