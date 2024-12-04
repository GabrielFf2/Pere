package com.example.demo.services;

import com.example.demo.entities.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieServiceMockImpl implements IMovieService{

    private List<Movie> repository = new ArrayList<>();

    @Override
    public Movie add(Movie movie) {
        movie.setId(repository.size() + 1);
        repository.add(movie);
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        return repository;
    }

    @Override
    public Movie findOne(long id) {
        return repository.stream().filter(movie -> movie.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Movie update(Movie movie) {
        Movie found = findOne(movie.getId());
        found.setTitle(movie.getTitle());
        found.setYear(movie.getYear());
        found.setSynopsis(movie.getSynopsis());
        return found;
    }

    @PostConstruct
    public void init() {
        repository.addAll(
                Arrays.asList(
                        new Movie(1,"Harry Potter", "The mage is bluff", 2001),
                        new Movie(2,"The Fall Guy", "Damage is real", 2024),
                        new Movie(3, "Moana 2", "Let's cook the chicken", 2024)
                )
        );

    }
}
