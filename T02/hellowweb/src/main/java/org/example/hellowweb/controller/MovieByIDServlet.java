package org.example.hellowweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hellowweb.dao.MovieDao;
import org.example.hellowweb.dao.MovieDaoJDBCImpl;
import org.example.hellowweb.model.Movie;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MovieByIDServlet", value = "/movieById")
public class MovieByIDServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Long id = Long.valueOf(request.getParameter("id"));

        MovieDao movieDao = new MovieDaoJDBCImpl();
        request.setAttribute("peli",movieDao.findByID(id));

        try {
            request.getRequestDispatcher("movie.jsp").forward(request,response);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        }


    }

    public void destroy() {
    }
}