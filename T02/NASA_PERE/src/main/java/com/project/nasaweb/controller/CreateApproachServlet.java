package com.project.nasaweb.controller;

import com.project.nasaweb.dao.AproachDaoImpl;
import com.project.nasaweb.dao.AsteroidsDaoImpl;
import com.project.nasaweb.model.Aproach;
import com.project.nasaweb.model.Asteroid;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@WebServlet(name = "createAproach", value = "/createAproach")
public class CreateApproachServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener los parámetros del formulario
            Long id = Long.parseLong(request.getParameter("id"));
            Long idAsteroid = Long.parseLong(request.getParameter("idAsteroid"));
            String dateString = request.getParameter("date");

            LocalDate date = LocalDate.parse(dateString);
            Date da = java.sql.Date.valueOf(date);

            double distance = Double.parseDouble(request.getParameter("distance"));
            double velocity = Double.parseDouble(request.getParameter("velocity"));
            String orbiting_body = request.getParameter("orbiting_body");

            AsteroidsDaoImpl asteroidsDao = new AsteroidsDaoImpl();
            Asteroid asteroid = asteroidsDao.findById(idAsteroid);

            // Crear un objeto Approach
            Aproach approach = new Aproach(id, da, distance, velocity , orbiting_body,asteroid);

            // Guardar el approach en la base de datos
            AproachDaoImpl approachesDao = new AproachDaoImpl();
            approachesDao.save(approach);

            // Redirigir a la lista de acercamientos del asteroide
            response.sendRedirect("aproaches?id=" + idAsteroid);

        } catch (Exception e) {
            // Manejar errores y redirigir con un mensaje de error
            request.setAttribute("errorMessage", "Error al crear el acercamiento: " + e.getMessage());
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Crear Aproach</title>");
            out.println("</head>");
            out.println("<h1>" + e.getMessage() + "</h1>");
            out.println("<body>");
            out.println("<h1>Crear Aproach</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long asteroidId = Long.valueOf(request.getParameter("idAsteroid"));
        request.setAttribute("asteroidId", asteroidId);
        request.getRequestDispatcher("createAproach.jsp").forward(request, response);
    }
}
