package com.project.nasaweb.Dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.project.nasaweb.Util.RestClient;
import com.project.nasaweb.models.Aproach;
import com.project.nasaweb.models.Asteroid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoNasaAPI implements INasaAPI {
    private final String url = "";
    private Asteroid asteroid;

    @Override
    public List<Asteroid> getDataNasa() {
        List<Asteroid> asteroids = new ArrayList<Asteroid>();
        try {
            List<JsonObject> jsonResult = RestClient.getResources();
            asteroids = createAsteroid(jsonResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return asteroids;
    }

    @Override
    public List<Asteroid> getDataNasaByDate(LocalDate dataStart, LocalDate dateEnd) {
        List<Asteroid> asteroids = new ArrayList<Asteroid>();


        for (LocalDate date = dataStart; !date.isAfter(dateEnd); date = date.plusDays(7)) {
            LocalDate nextDate = date.plusDays(6);
            try {
                String startDateStr = String.valueOf(date);
                String endDateStr = String.valueOf((nextDate.isBefore(dateEnd) ? nextDate : dateEnd));
                List<JsonObject> jsonResult = RestClient.getResources(startDateStr, endDateStr);
                asteroids = createAsteroid(jsonResult);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return asteroids;
    }

    private List<Asteroid> createAsteroid(List<JsonObject> jsonResult) throws ParseException {
        List<Asteroid> asteroids = new ArrayList<>();
        for (JsonObject jsonObject : jsonResult) {
            Long id = jsonObject.get("id").getAsLong();
            String name = jsonObject.get("name").getAsString();
            float absoluteMagnitude = jsonObject.get("absolute_magnitude_h").getAsFloat();
            JsonObject estimatedDiameter = jsonObject.getAsJsonObject("estimated_diameter");
            JsonObject kilometers = estimatedDiameter.getAsJsonObject("kilometers");
            float diameterKmMin = kilometers.get("estimated_diameter_max").getAsFloat();
            float diameterKmMax = kilometers.get("estimated_diameter_min").getAsFloat();
            float diameterKmAverage = (diameterKmMin + diameterKmMax) / 2;
            int isPotentiallyHazardous = jsonObject.get("is_potentially_hazardous_asteroid").getAsBoolean() ? 1 : 0;

            List<Aproach> listAproach = new ArrayList<>();
            Asteroid asteroid = new Asteroid(id, name, absoluteMagnitude, diameterKmAverage, isPotentiallyHazardous, listAproach);
            JsonArray aproachArray = jsonObject.get("close_approach_data").getAsJsonArray();
            for (JsonElement jsonElement : aproachArray) {
                JsonObject approachObject = jsonElement.getAsJsonObject();
                String dateString = approachObject.get("close_approach_date").getAsString();
                Date aproachDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);

                JsonObject relativeVelocity = approachObject.getAsJsonObject("relative_velocity");
                float velocity = relativeVelocity.get("kilometers_per_hour").getAsFloat();

                JsonObject missDistance = approachObject.getAsJsonObject("miss_distance");
                float distance = missDistance.get("kilometers").getAsFloat();

                String orbitingBody = approachObject.get("orbiting_body").getAsString();
                Aproach aproach = new Aproach(0, asteroid, aproachDate, velocity, distance, orbitingBody);
                listAproach.add(aproach);
            }
            asteroids.add(asteroid);
        }
        return asteroids;
    }
}
