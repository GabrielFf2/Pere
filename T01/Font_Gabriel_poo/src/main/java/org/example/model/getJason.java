package org.example.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.service.IRickAndMortyService;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getJason {
    private static final String URL = IRickAndMortyService.URL_PERSONATGES;

    private static final String URLepisodis = IRickAndMortyService.URL_EPISODIS;


    public static List<JsonObject> getAllPersonatges() {
        try {
            String json = connexio(URL);

            Gson gson = new Gson();
            JsonArray audiovisualsArray = gson.fromJson(json, JsonArray.class);

            return audiovisualsArray.asList().stream().map(n -> n.getAsJsonObject()).toList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<JsonObject> getAllEpisodis()  {
        try {
            String json = connexio(URLepisodis);

            Gson gson = new Gson();
            JsonArray audiovisualsArray = gson.fromJson(json, JsonArray.class);

            return audiovisualsArray.asList().stream().map(n -> n.getAsJsonObject()).toList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return List.of();
    }

    private static String connexio(String api) throws IOException {
        ignoreSSLCertificate();

        java.net.URL url = new URL(api);
        URLConnection connection = url.openConnection();
        connection.connect();

        String contentType = connection.getContentType();
        Charset charset = getCharsetFromContentType(contentType);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset))) {
            StringBuilder outputLine = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                outputLine.append(inputLine);
            }
            //System.out.println(outputLine);
            return outputLine.toString();
        } catch (IOException e) {
            throw new IOException("Error de connexió amb el servidor: " + e.getMessage(), e);
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

    private static void ignoreSSLCertificate() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            HostnameVerifier allHostsValid = (hostname, session) -> true;
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}






















