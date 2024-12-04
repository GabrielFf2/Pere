package com.project.nasaweb.controller;

import java.io.*;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import com.project.nasaweb.dao.NasaApiImpl;
import com.project.nasaweb.model.Asteroid;
import com.project.nasaweb.service.ServicesNasa;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "asteroids", value = "/asteroids")
public class AsteroidServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServicesNasa servicesNasa = new ServicesNasa();

        List<Asteroid> asteroids;

        asteroids = servicesNasa.getAsteroids();
        servicesNasa.saveAsteroids(asteroids);

        // Guardar la lista en la sesión
        request.getSession().setAttribute("asteroids", asteroids);

        response.sendRedirect("asteroids.jsp");
    }

    public void destroy() {
    }

}
