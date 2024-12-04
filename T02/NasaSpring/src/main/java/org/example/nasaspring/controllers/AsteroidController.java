package org.example.nasaspring.controllers;

import org.example.nasaspring.entities.Asteroid;
import org.example.nasaspring.services.INasa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AsteroidController {

    @Autowired
    @Qualifier("nasaMockImpl")
    private INasa nasaService;

    @GetMapping("/asteroids")
    public String asteroids(Model model) {
        {
            model.addAttribute("asteroids", nasaService.asteroids());
            return "asteroid/asteroids";
        }
    }

    @GetMapping("/asteroids/form")
    public String asteroidForm(Model model) {
        Asteroid asteroid = new Asteroid();
        model.addAttribute("asteroid", asteroid);
        nasaService.saveAsteroid(asteroid);
        return "asteroid/form";
    }

    @PostMapping("/asteroids/form")
    public String asteroidForm2(@ModelAttribute Asteroid asteroid) {
        nasaService.saveAsteroid(asteroid);
        return "redirect:/asteroids";
    }


    @GetMapping("/asteroids/form/{id}")
    public String asteroidForm(Model model, @PathVariable String id) {
        model.addAttribute("asteroid", nasaService.asteroidById(Long.parseLong(id)));
        return "asteroid/form";
    }

    @PostMapping("/asteroids/form/{id}")
    public String asteroidForm1(@ModelAttribute Asteroid asteroid) {
        nasaService.updateAsteroid(asteroid);
        return "redirect:/asteroids";
    }

    @PostMapping("/asteroids/delete/{id}")
    public String deleteAsteroid(@PathVariable String id) {
        nasaService.deleteAsteroid(Long.parseLong(id));
        return "redirect:/asteroids";
    }
}
