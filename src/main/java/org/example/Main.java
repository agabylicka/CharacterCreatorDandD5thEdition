package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, give the name of your character");
        String answer = scanner.nextLine();
        System.out.println("Please, give the race of your character");
        String answer1 = scanner.nextLine();
        System.out.println("Please, give the class of your character");
        String answer2 = scanner.nextLine();
        System.out.println("Please, select spells or/and cantrips of your character");
        String answer3 = scanner.nextLine();
        System.out.println("Please write background for your character");
        String answer4 = scanner.nextLine();

        File file = new File("src\\main\\java\\org\\example\\" + answer + ".txt");
        try {
            boolean created = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.flush();
            bufferedWriter.write("race: " + answer1);
            bufferedWriter.write("\n");
            bufferedWriter.write("class: " + answer2);
            bufferedWriter.write(("\n"));
            //TODO user should select spells (and race and class)
            bufferedWriter.write("spells or/and cantrips: " + answer3);
            bufferedWriter.write(("\n"));
            bufferedWriter.write("background: " + answer4);
            bufferedWriter.write(("\n"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}







