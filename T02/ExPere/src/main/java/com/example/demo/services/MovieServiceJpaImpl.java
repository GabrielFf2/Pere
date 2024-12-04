package com.example.demo.services;

import com.example.demo.entities.Movie;
import com.example.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceJpaImpl implements IMovieService{

    @Autowired
    MovieRepository repository;

    @Override
    public Movie add(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public Movie findOne(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Movie update(Movie movie) {
        return repository.save(movie);
    }
}
