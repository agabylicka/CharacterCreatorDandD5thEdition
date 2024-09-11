package org.example.HTTP;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

public class ClassSpells {
    private final String address = "https://www.dnd5eapi.co/api/classes/:index/levels/1/spells";
    private final String addressAll = "https://www.dnd5eapi.co/api/spells";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getClassSpells(String index) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(address.replace(":index", index))).GET().build();
            HttpResponse<String>response = client.send(request,HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (URISyntaxException | InterruptedException | IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAllSpells() {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(addressAll)).GET().build();

            String resp = HttpClient.newHttpClient()
                    .sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .get();

            return resp;

        } catch (URISyntaxException | InterruptedException | NullPointerException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
