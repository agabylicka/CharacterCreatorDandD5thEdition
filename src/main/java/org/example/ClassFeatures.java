package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassFeatures {         ///api/classes/:index/levels/:class_level/features
    private final String userURL = "https://www.dnd5eapi.co/api/classes/:index/levels/1/features";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getClassFeatures(String index) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(userURL.replace(":index", index))).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

