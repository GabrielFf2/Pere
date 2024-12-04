package com.project.nasaweb.Util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestClient {
    private static final String URL = "https://api.nasa.gov/neo/rest/v1/feed?";
    private static final String API_KEY = "DxZV8Tf6m3eOxy3cVd0Cy3qULyhaHtVXMgBIzQPI";

    public static List<JsonObject> getResources() throws IOException {
        String urlApi = URL + "&api_key=" + API_KEY;
        return getJsonObjects(urlApi);
    }

    public static List<JsonObject> getResources(String start, String end) throws IOException {
        List<JsonObject> returns = new ArrayList<>();
        String urlApi = URL + "start_date=" + start + "&end_date=" + end + "&api_key=" + API_KEY;
        return getJsonObjects(urlApi);
    }

    private static List<JsonObject> getJsonObjects(String urlApi) throws IOException {
        List<JsonObject> returns = new ArrayList<>();
        String json = connexio(urlApi);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject nearEarthObjects = jsonObject.getAsJsonObject("near_earth_objects");
        for (String key : nearEarthObjects.keySet()) {
            JsonArray objectsArray = nearEarthObjects.getAsJsonArray(key);
            for (JsonElement element : objectsArray) {
                returns.add(element.getAsJsonObject());
            }
        }
        return returns;
    }

    private static String connexio(String api) throws IOException {
        java.net.URL url = new URL(api);
        URLConnection con = url.openConnection();
        con.connect();
        String contentType = con.getContentType();
        Charset charset = getCharsetFromContentType(contentType);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), charset))) {
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        } catch (IOException e) {
            throw new IOException("Error connexio: " + e.getMessage());
        }
    }

    private static Charset getCharsetFromContentType(String contentType) {
        if (contentType != null) {
            Pattern pattern = Pattern.compile("charset=([\\w\\-]+)");
            Matcher matcher = pattern.matcher(contentType);
            if (matcher.find()) {
                return Charset.forName(matcher.group(1));
            }
        }
        System.out.println("No s'ha especificat charset en el Content-Type. Usant ISO-8859-1 com a predeterminat.");
        return StandardCharsets.ISO_8859_1;
    }
}
