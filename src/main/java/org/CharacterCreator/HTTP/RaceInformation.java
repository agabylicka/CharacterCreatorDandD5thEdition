package org.CharacterCreator.HTTP;

import org.CharacterCreator.DataModel.Race;
import org.CharacterCreator.MAPPERS.RaceMAPPER;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RaceInformation {
    private final String address = "https://www.dnd5eapi.co/api/races/:index";
    private final HttpClient client = HttpClient.newHttpClient();

    public Race getRaceInformation(String index) throws RuntimeException {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(address.replace(":index", index))).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Race race = RaceMAPPER.convertJSON(response.body());
            return race;
        } catch (IOException | URISyntaxException | InterruptedException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
