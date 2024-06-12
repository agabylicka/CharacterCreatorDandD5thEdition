package org.example;

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        ClassInformation classInformation = new ClassInformation();
        System.out.println(classInformation.getClassInformation("barbarian"));
        HttpResponse<String> response = classInformation.getClassInformation("barbarian");
        System.out.println(response.statusCode());
        System.out.println(response.body());
        System.out.println(response.headers());

        ClassResources classResources = new ClassResources();
        System.out.println(classResources.getClassResources("barbarian"));
        HttpResponse<String> response1 = classInformation.getClassInformation("barbarian");
        System.out.println(response1.statusCode());
        System.out.println(response1.body());
        System.out.println(response1.headers());

    }





}