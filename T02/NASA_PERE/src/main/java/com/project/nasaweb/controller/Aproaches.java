package com.project.nasaweb.controller;


import java.io.*;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;

import com.project.nasaweb.dao.NasaApiImpl;
import com.project.nasaweb.model.Aproach;
import com.project.nasaweb.model.Asteroid;
import com.project.nasaweb.service.ServicesNasa;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "aproaches", value = "/aproaches")
public class Aproaches extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Long id = Long.valueOf(request.getParameter("id"));

        ServicesNasa servicesNasa = new ServicesNasa();

        List<Aproach> aproaches = servicesNasa.getAproaches(id);

        request.getSession().setAttribute("idAsteroid",id);

        request.getSession().setAttribute("aproaches", aproaches);

        response.sendRedirect("aproaches.jsp");


    }

    public void destroy() {
    }

}