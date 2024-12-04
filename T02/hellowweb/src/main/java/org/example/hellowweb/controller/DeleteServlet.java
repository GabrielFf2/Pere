package org.example.hellowweb.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.hellowweb.dao.MovieDao;
import org.example.hellowweb.dao.MovieDaoJDBCImpl;

import java.io.IOException;


@WebServlet(name = "DeleteServlet", value = "/delete")
public class DeleteServlet extends HttpServlet {

    private MovieDao movieDao;

    @Override
    public void init() throws ServletException {
        movieDao = new MovieDaoJDBCImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        movieDao.deleteByID(id);
        response.sendRedirect("movies");
    }

}