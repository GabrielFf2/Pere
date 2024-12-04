package com.project.nasaweb.controller;

import com.project.nasaweb.dao.AsteroidsDaoImpl;
import com.project.nasaweb.model.Asteroid;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "createAsteroid", value = "/createAsteroid")
public class CreateAsteroid extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        double Magnitud = Double.parseDouble(request.getParameter("Magnitud"));
        double Diametro = Double.parseDouble(request.getParameter("Diametro"));
        boolean perillos ;
        String dangerValue = request.getParameter("danger");

        // Verificar si el checkbox estaba marcado
        if (dangerValue != null) {
            perillos = true;
        } else {
            perillos = false;
        }

        Asteroid asteroid = new Asteroid(id,name,Magnitud,Diametro,perillos);

        AsteroidsDaoImpl asteroidsDao = new AsteroidsDaoImpl();

        asteroidsDao.save(asteroid);

        response.sendRedirect("asteroids");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("createAsteroid.jsp");
    }

}
