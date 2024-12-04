package com.example.demo.repositories;

import com.example.demo.entities.Movie;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends ListCrudRepository<Movie,Long> {
    List<Movie> findByTitle(String title);
    List<Movie> findByYearBetween(int min, int max);
}
