package org.example.hellowweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hellowweb.dao.MovieDao;
import org.example.hellowweb.dao.MovieDaoJDBCImpl;

import java.io.IOException;

@WebServlet(name = "MoviesServlet", value = "/movies")
public class MoviesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        MovieDao movieDao = new MovieDaoJDBCImpl();
        request.setAttribute("pelis",movieDao.findAll());

        try {
            request.getRequestDispatcher("movies.jsp").forward(request,response);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        }

    }


}