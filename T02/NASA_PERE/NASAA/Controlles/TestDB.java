package com.project.nasaweb.Controlles;

import com.google.gson.JsonObject;
import com.project.nasaweb.Dao.DaoNasaAPI;
import com.project.nasaweb.Dao.DaoNasaDB;
import com.project.nasaweb.Util.RestClient;
import com.project.nasaweb.models.Aproach;
import com.project.nasaweb.models.Asteroid;
import com.project.nasaweb.service.NasaService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TestDB", value = "/TestDB")
public class TestDB extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NasaService nasaService = new NasaService();
        DaoNasaDB nasaDB = new DaoNasaDB();
        DaoNasaAPI nasaAPI = new DaoNasaAPI();

        response.setContentType("text/html");
        List<Asteroid> list = new ArrayList<>();
        List<Asteroid> list2 = new ArrayList<>();
        LocalDate start = LocalDate.of(2022, 1, 13);
        LocalDate end = LocalDate.of(2022, 1, 23);
//        list = nasaAPI.getDataNasaByDate(start, end);

        list = nasaService.getAsteroidsByApisRepet(start, end);
//        list2 = nasaService.getAsteroidsByApi(start, end);
//        list = nasaService.getAsteroids();
        Asteroid asteroid = nasaService.getAsteroidsByID(2007482);
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(asteroid != null) {

        out.println("<h1>SelectByID = " + asteroid.getId() + " - " + asteroid.getName() + "</h1>");
        }
//        String result = nasaService.deleteAsteroidById(asteroid.getId());
//        nasaDB.updateAsteroid(asteroid);
//        out.println("<h1>SelectByID = " + result + "</h1>");
        out.println("<h1>---------------------------------</h1>");
        out.println("<h1>ResultQuery = " + list.size() + "</h1>");
        list.forEach(x -> {
            out.println("<p>" + x.getId() + " - " + x.getName() + "</p>");
            x.getApproaches().forEach(a -> {
                out.println("<p> ---" + a.getAproachDate().toString() + "</p>");
            });
        });
        out.println("</body></html>");
    }

}