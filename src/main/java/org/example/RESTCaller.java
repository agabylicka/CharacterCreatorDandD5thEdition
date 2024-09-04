package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RESTCaller {

    public static String get(String uri) {
        if (uri == null || uri.trim().isEmpty() || uri.contains(" ")) {
            return null;
        }

        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(uri.trim());
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int response = connection.getResponseCode();
            if (response == 200) {
                return "OK";
            }
        } catch (IOException e) {
            //TODO handled the exception
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

}
