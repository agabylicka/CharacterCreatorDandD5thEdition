package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//"https://www.dnd5eapi.co/api/races/:index/proficiencies"; GET /api/races/:index
public class RaceInformation {
    private final String userURL = "https://www.dnd5eapi.co/api/races/:index";
    private final HttpClient client = HttpClient.newHttpClient();
    public HttpResponse<String> getRaceInformation(String index) throws RuntimeException {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(userURL.replace(":index", index))).GET().build();
            HttpResponse<String>response = client.send(request,HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException | URISyntaxException | InterruptedException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
