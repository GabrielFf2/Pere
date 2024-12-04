package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("saludo", "Hola som en Pere");
        return "hello";
    }

    @GetMapping("/test")
    public String hello(@RequestParam(name = "nom", required = false, defaultValue = "Antonio") String nom, Model model){
        model.addAttribute("nom", nom);
        return "helloWithParams";
    }

    @GetMapping("/twoparams/{nom}/{llinatge}")
    public String helloInPath(@PathVariable String nom, @PathVariable String llinatge, Model model){
        model.addAttribute("nom", nom);
        model.addAttribute("llinatge", llinatge);
        return "helloWithTwoParams";
    }
}
