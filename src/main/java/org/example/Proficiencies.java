package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Proficiencies {
    private final String address = "https://www.dnd5eapi.co/api/races/:index/proficiencies";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getProficiencies(String index) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(address.replace(":index", index))).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException | URISyntaxException | InterruptedException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
