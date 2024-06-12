package org.example;
/* A service has been created to connect to D&D API The methods available in the service are:

    getClassInformation → Ask for the class using index value provided in the documentation. Use 1st level as an
    argument to limit the response. What is returned is the HttpResponse;

 */

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClassInformation {
    //Ask for the class using index value provided in the documentation.
    //TODO Use 1st level as an argument to limit the response.
    //What is returned is the HttpResponse;
    private final String userURL = "https://www.dnd5eapi.co/api/classes";
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getClassInformation(String index) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder(new URI(userURL + "/" + index)).GET().build();
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
