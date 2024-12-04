package org.example;

import com.google.gson.JsonObject;
import org.example.model.Canco;
import org.example.util.AudiovisualProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudiovisualServiceExternImpl implements IAudioVisual {

    @Override
    public List<Canco> findAllCanconsLliures() throws IOException {
        List<JsonObject> audiovisuals = AudiovisualProvider.getAudiovisuals();

        List<Canco> cancons = new ArrayList<>();
        for (JsonObject jsonObject : audiovisuals) {
            String tipus = jsonObject.get("type").getAsString();

            if (tipus.equalsIgnoreCase("Canço") && (
                    jsonObject.get("copyRight") == null ||
                            jsonObject.get("copyRight").isJsonNull() ||
                            !jsonObject.get("copyRight").getAsBoolean()
            )) {
                String nom = jsonObject.get("name").getAsString();
                String artista = jsonObject.get("artist").getAsString();

                Canco canco = new Canco(nom, artista);
                cancons.add(canco);
            }
        }
        return cancons;
    }

    @Override
    public List<Canco> findAllCancons() throws IOException {
        List<JsonObject> audiovisuals = AudiovisualProvider.getAudiovisuals();

        List<Canco> cancons = new ArrayList<>();
        for (JsonObject jsonObject : audiovisuals) {
            String tipus = jsonObject.get("type").getAsString();

            if (tipus.equalsIgnoreCase("Canço")) {
                String nom = jsonObject.get("name").getAsString();
                String artista = jsonObject.get("artist").getAsString();

                String duration = jsonObject.get("duration").getAsString();
                String[] splitedDuration = duration.split(":");
                int temps = Integer.parseInt(splitedDuration[0]) * 60 + Integer.parseInt(splitedDuration[1]);

                Canco canco = new Canco(nom, artista);
                canco.setTemps(temps);
                cancons.add(canco);
            }
        }
        return cancons;
    }
}