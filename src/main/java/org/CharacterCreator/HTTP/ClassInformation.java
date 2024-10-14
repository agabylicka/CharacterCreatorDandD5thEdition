package org.CharacterCreator.HTTP;

import org.CharacterCreator.DataModel.CharacterClass;
import org.CharacterCreator.MAPPERS.CharacterClassMAPPER;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassInformation {
    private final String address = "https://www.dnd5eapi.co/api/classes";
    private final HttpClient client = HttpClient.newHttpClient();

    public CharacterClass getClassInformation(String index) {
        HttpRequest request;
        if (index == null || index.trim().isEmpty()) {
            return null;
        }
        try {
            request = HttpRequest.newBuilder(new URI(address + "/" + index)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            CharacterClass characterClass = CharacterClassMAPPER.convertJSON(response.body());
            return characterClass;
        } catch (URISyntaxException | InterruptedException | IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}