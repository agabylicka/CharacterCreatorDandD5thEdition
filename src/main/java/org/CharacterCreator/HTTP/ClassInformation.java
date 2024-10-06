package org.CharacterCreator.HTTP;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassInformation {
    private final String address = "https://www.dnd5eapi.co/api/classes";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getClassInformation(String index) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(address + "/" + index)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (URISyntaxException | InterruptedException | IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}