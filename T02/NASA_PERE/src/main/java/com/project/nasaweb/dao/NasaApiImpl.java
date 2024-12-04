package com.project.nasaweb.dao;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.project.nasaweb.model.Aproach;
import com.project.nasaweb.model.Asteroid;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NasaApiImpl implements INasaApiDao {
    @Override
    public List<Asteroid> getAsteroids() throws URISyntaxException, IOException, InterruptedException, ParseException {
        String apiKey = "DxZV8Tf6m3eOxy3cVd0Cy3qULyhaHtVXMgBIzQPI";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.nasa.gov/neo/rest/v1/neo/browse?api_key=" + apiKey))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonArray nearEarthObjects = null;
        try {
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            nearEarthObjects = jsonObject.getAsJsonArray("near_earth_objects");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (nearEarthObjects == null || nearEarthObjects.isEmpty()) {
            System.out.println("No se encontraron asteroides en la respuesta.");
            return List.of();
        }

        List<Asteroid> asteroidList = new ArrayList<>();
        for (JsonElement element : nearEarthObjects) {
            JsonObject object = element.getAsJsonObject();

            Long id = object.get("id").getAsLong();
            String name = object.get("name").getAsString();
            double magnitude = object.get("absolute_magnitude_h").getAsDouble();

            JsonObject estimatedDiameter = object.getAsJsonObject("estimated_diameter")
                    .getAsJsonObject("kilometers");
            double min = estimatedDiameter.get("estimated_diameter_min").getAsDouble();
            double max = estimatedDiameter.get("estimated_diameter_max").getAsDouble();
            double diameter = (max + min) / 2;

            boolean isDangerous = object.get("is_potentially_hazardous_asteroid").getAsBoolean();

            Asteroid asteroid = new Asteroid(id, name, magnitude, diameter, isDangerous);

            List<Aproach> listApproach = new ArrayList<>();

            JsonArray approachArray = object.getAsJsonArray("close_approach_data");
            for (JsonElement approachElement : approachArray) {
                JsonObject approach = approachElement.getAsJsonObject();

                String approachDate = approach.get("close_approach_date").getAsString();
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(approachDate);

                JsonObject velocityObject = approach.getAsJsonObject("relative_velocity");
                double velocity = velocityObject.get("kilometers_per_hour").getAsDouble();

                JsonObject missDistanceObject = approach.getAsJsonObject("miss_distance");
                double distance = missDistanceObject.get("kilometers").getAsDouble();

                String orbitingBody = approach.get("orbiting_body").getAsString();

                Aproach aproach = new Aproach(null, date, velocity, distance, orbitingBody, asteroid);
                listApproach.add(aproach);
            }

            asteroid.setAproach(listApproach);
            asteroidList.add(asteroid);
        }
        return asteroidList;
    }
}
