package com.project.nasaweb.controller;

import com.project.nasaweb.dao.AsteroidsDaoImpl;
import com.project.nasaweb.model.Asteroid;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "updateAsteroid", value = "/updateAsteroid")
public class UpdateAsteroid extends HttpServlet {

    private final AsteroidsDaoImpl asteroidsDao = new AsteroidsDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            Double magnitud = Double.valueOf(request.getParameter("Magnitud"));
            Double diametro = Double.valueOf(request.getParameter("Diametro"));
            boolean perillos = request.getParameter("danger") != null;

            Asteroid asteroid = new Asteroid(id, name, magnitud, diametro, perillos);
            asteroidsDao.updateAsteroid(asteroid);

            response.sendRedirect("asteroids");
        } catch (NumberFormatException | NullPointerException e) {
            // Manejo de errores de conversión o parámetros faltantes
            request.setAttribute("error", "Datos inválidos. Verifica los campos e inténtalo de nuevo.");
            request.getRequestDispatcher("updateAsteroid.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long id = Long.parseLong(request.getParameter("id"));
            Asteroid asteroid = asteroidsDao.findById(id);

            if (asteroid != null) {
                request.setAttribute("asteroid", asteroid);
                request.getRequestDispatcher("updateAsteroid.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Asteroide no encontrado");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }
    }
}
