package org.example.hellowweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hellowweb.dao.MovieDao;
import org.example.hellowweb.dao.MovieDaoJDBCImpl;
import org.example.hellowweb.model.Movie;

import java.io.IOException;

@WebServlet(name = "CreateServlet", value = "/create")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Integer year = Integer.valueOf(request.getParameter("year"));

        Movie movie = new Movie(null,title,year,description);

        MovieDao movieDao = new MovieDaoJDBCImpl();
        request.setAttribute("movie", movieDao.createMovie(movie));

        response.sendRedirect("movies");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(request, response);
    }


}