package org.example.vetplus.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.vetplus.dao.ITipusDao;
import org.example.vetplus.dao.TipusDaoImpl;
import org.example.vetplus.service.TipusService;

public class TipusController extends HttpServlet {
    TipusService tipusService ;

    public TipusController() {
        this.tipusService = new TipusService(new TipusDaoImpl());
    }

    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response){


    }

}
