package org.example.hellowweb.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.hellowweb.dao.MovieDao;
import org.example.hellowweb.dao.MovieDaoJDBCImpl;
import org.example.hellowweb.model.Movie;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstMovieServlet", value = "/first")
public class FirstMovieServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Llista de pelis";
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        MovieDao movieDao = new MovieDaoJDBCImpl();
        Movie movie = movieDao.findByID(1L);
        out.println(movie + "<br>");

        out.println("</body></html>");

    }

}