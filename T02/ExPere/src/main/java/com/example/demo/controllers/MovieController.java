package com.example.demo.controllers;

import com.example.demo.entities.Movie;
import com.example.demo.services.IMovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    @Autowired
    @Qualifier("movieServiceMockImpl")
    private IMovieService movieService;

    @GetMapping("/movie")
    public String newMovie(Model model){
        model.addAttribute("movieForm", new Movie());
        return "movie/form";
    }

    @PostMapping("/movie")
    public String newMovieSubmit(@ModelAttribute("movieForm") Movie movie){

            movieService.add(movie);
            return "redirect:/movies";

    }

    @GetMapping("/movie/edit/{id}")
    public String editMovie(@PathVariable long id, Model model){
        Movie movie =  movieService.findOne(id);

        if (movie == null) {
            return "redirect:/movie";
        } else {
            model.addAttribute("movieForm", movie);
            return "movie/form";
        }

    }

    @PostMapping("/movie/edit")
    public String editMovieSubmit(@Valid @ModelAttribute("movieForm") Movie movie, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "movie/form";
        } else{
            movieService.update(movie);
            return "redirect:/movies";
        }
    }

    @GetMapping("/movies")
    public String movies(Model model){
        model.addAttribute("movies", movieService.findAll());
        return "movie/movies";
    }
}
