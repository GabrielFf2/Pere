package com.project.nasaweb.controller;

import com.project.nasaweb.dao.NasaApiImpl;
import com.project.nasaweb.model.Asteroid;
import com.project.nasaweb.service.ServicesNasa;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;


@WebServlet(name = "eliminar", value = "/eliminar")
public class EliminarMetrorit extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Long id = Long.valueOf(request.getParameter("id"));

        ServicesNasa servicesNasa = new ServicesNasa();

        servicesNasa.deleteAsteroid(id);

        response.sendRedirect("asteroids");
    }

    public void destroy() {
    }
}
