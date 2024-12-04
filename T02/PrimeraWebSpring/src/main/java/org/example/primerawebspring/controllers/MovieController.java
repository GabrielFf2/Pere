package org.example.primerawebspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    @GetMapping("/")
    public String index(@RequestParam String edat , Model model) {
        model.addAttribute("nom", "Gabri");
        model.addAttribute("age", edat);

        return "index";
    }

    @GetMapping("/movies")
    public String getMovies() {
        return "movies/moviesList";
    }

    @GetMapping("/movies/{nom}/{anys}")
    public String movies(@PathVariable String nom,@PathVariable String anys , Model model) {
        model.addAttribute("nom", nom);
        model.addAttribute("age", anys);
        return "index";
    }

    //primer la ruta que te parametres




}







