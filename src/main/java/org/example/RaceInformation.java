package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//"https://www.dnd5eapi.co/api/races/:index/proficiencies"; GET /api/races/:index
public class RaceInformation {
    public final String userURL = "https://www.dnd5eapi.co/api/races/:index";
    public final HttpClient client = HttpClient.newHttpClient();
    public HttpResponse<String> getRaceInformation(String index) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(userURL.replace(":index", index))).GET().build();
            HttpResponse<String>response = client.send(request,HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
