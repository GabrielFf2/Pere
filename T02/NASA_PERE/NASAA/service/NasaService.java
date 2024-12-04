package com.project.nasaweb.service;

import com.project.nasaweb.Dao.INasaAPI;
import com.project.nasaweb.Dao.INasaDB;
import com.project.nasaweb.Dao.DaoNasaAPI;
import com.project.nasaweb.Dao.DaoNasaDB;
import com.project.nasaweb.models.Asteroid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NasaService {
    INasaAPI nasaApi;
    INasaDB nasaDB;

    public NasaService() {
        nasaApi = new DaoNasaAPI();
        nasaDB = new DaoNasaDB();
    }

    public List<Asteroid> getAsteroids() {
        return nasaDB.getAllAsteroids();
    }

    public Asteroid getAsteroidsByID(int id) {
        return nasaDB.getAsteroidById(id);
    }

    public String updateAsteroid(Asteroid asteroid) {
        return nasaDB.updateAsteroid(asteroid);
    }

    public String deleteAsteroidById(long id) {
        return nasaDB.deleteAsteroidById(id);
    }

    public String inster(List<Asteroid> list) {
        return nasaDB.insertAsteroids(list);
    }

    public List<Asteroid> getAsteroidsByApi() {
        return nasaApi.getDataNasa();
    }

    public List<Asteroid> getAsteroidsByApi(LocalDate startDate, LocalDate endDate) {
        return nasaApi.getDataNasaByDate(startDate, endDate);
    }

    public List<Asteroid> getAsteroidsByApisRepet(LocalDate startDate, LocalDate endDate) {
        List<Asteroid> list = nasaApi.getDataNasaByDate(startDate, endDate);
        List<Asteroid> returnList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getId() == list.get(j).getId()) {
                    returnList.add(list.get(i));
                }
            }
        }
        return returnList;
    }
}
