package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RESTCaller {

    public static String exists(String uri) {
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

    public static String passContent(String uri) {
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
            if (response == connection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer responseBuffer = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    responseBuffer.append(inputLine);
                }
                in.close();
                return responseBuffer.toString();
            } else {
                System.out.println("Error found !!!");
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
