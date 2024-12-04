package com.project.nasaweb.controller;

import com.project.nasaweb.dao.NasaApiImpl;
import com.project.nasaweb.model.Asteroid;
import com.project.nasaweb.service.ServicesNasa;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "saveAsteroids", value = "/saveAsteroids")
public class SaveNasaAsteroids extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        NasaApiImpl nasaApi = new NasaApiImpl();
        ServicesNasa servicesNasa = new ServicesNasa();

        try {
            servicesNasa.saveAsteroids(nasaApi.getAsteroids());

        } catch (URISyntaxException | InterruptedException | ParseException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("asteroids");
    }

    public void destroy() {
    }

}
