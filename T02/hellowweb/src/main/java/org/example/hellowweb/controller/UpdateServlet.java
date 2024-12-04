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


@WebServlet(name = "UpdateServlet", value = "/update")
public class UpdateServlet extends HttpServlet {

    private MovieDao movieDao;

    @Override
    public void init() throws ServletException {
        movieDao = new MovieDaoJDBCImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Integer year = Integer.valueOf(request.getParameter("year"));
        Long id = Long.valueOf(request.getParameter("id"));

        Movie movie = new Movie(id,title, year, description );
        movieDao.update(movie);

        response.sendRedirect("movies");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        request.setAttribute("peli", movieDao.findByID(id));
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

}