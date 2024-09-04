package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, give the name of your character");
        String answer = scanner.nextLine();

        String answer1;
        boolean existingRace = false;
        do {
            System.out.println("Please, give valid race name of your character");
            answer1 = scanner.nextLine();

            String response = RESTCaller.exists("https://www.dnd5eapi.co/api/races/%s".formatted(answer1));
            if (response != null && response.trim().equals("OK")) {
                existingRace = true;
            }
        } while (!existingRace);

        String answer2;
        boolean existingClass = false;
        do {
            System.out.println("Please, give the class of your character");
            answer2 = scanner.nextLine();

            String response = RESTCaller.exists("https://www.dnd5eapi.co/api/classes/%s".formatted(answer2));
            if (response != null && response.trim().equals("OK")) {
                existingClass = true;
            }
        } while (!existingClass);

        String responseSpells = RESTCaller.passContent("https://www.dnd5eapi.co/api/classes/%s/spellcasting"
                .formatted(answer2));
        boolean spellsExist = responseSpells != null;
        if (spellsExist) {
            // TODO DEBUG INFO
            System.out.println(responseSpells);
            return;
        }

        String answer3 = "";
        if (spellsExist) {
            System.out.println("Please, select spells or/and cantrips of your character");
            answer3 = scanner.nextLine();
        }

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
            //TODO user is able to select spells/cantrips if available (can be done via a list and number of the spell);
            bufferedWriter.write("spells or/and cantrips: " + answer3);
            bufferedWriter.write(("\n"));
            bufferedWriter.write("background: " + answer4);
            bufferedWriter.write(("\n"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //TODO Everything has been tested properly. */
    }
}







