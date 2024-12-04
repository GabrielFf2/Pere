package org.example;

import com.google.gson.JsonObject;
import org.example.model.Canco;
import org.example.util.AudiovisualProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioVisualServiceExternalImpl {
    public List<Canco> findAllCanconsLliures() throws IOException {
        List<Canco> cancos = new ArrayList<Canco>();
        List<JsonObject> json = AudiovisualProvider.getAudiovisuals();

        for (JsonObject jsonObject : json) {
            String tipus = jsonObject.get("type").getAsString();
            if (tipus.equalsIgnoreCase("Canço") && (jsonObject.get("copyRight").isJsonNull() || !jsonObject.get("copyRight").getAsBoolean())) {
                String titol = jsonObject.get("name").getAsString();
                String artist = jsonObject.get("artist").getAsString();
                cancos.add(new Canco(titol, artist));
            }
        }
        return cancos;
    }

    public List<Canco> findAllCancons() throws IOException {
        List<Canco> cancos = new ArrayList<Canco>();
        List<JsonObject> json = AudiovisualProvider.getAudiovisuals();

        for (JsonObject jsonObject : json) {
            String tipus = jsonObject.get("type").getAsString();
            if (tipus.equalsIgnoreCase("Canço")) {
                String titol = jsonObject.get("name").getAsString();
                String artist = jsonObject.get("artist").getAsString();
                String duration = jsonObject.get("duration").getAsString();
                String[] durationNew = duration.split(":");
                int timeSeconds = Integer.parseInt(durationNew[0]) * 60 + Integer.parseInt(durationNew[1]);
                Canco canco = new Canco(titol, artist);
                canco.setTemps(timeSeconds);
                cancos.add(canco);
            }
        }
        return cancos;
    }
}
