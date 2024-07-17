package org.example;

import com.sun.net.httpserver.Request;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassResources {
    //Ask for the class using index value provided in the documentation.
    //TODO Use 1st level as an argument to limit the response.
    //What is returned is the HttpResponse;
    private final String userURL = "https://www.dnd5eapi.co/api/classes/:index/levels/1";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getClassResources(String index) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(userURL.replace(":index", index))).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (URISyntaxException | InterruptedException | IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
