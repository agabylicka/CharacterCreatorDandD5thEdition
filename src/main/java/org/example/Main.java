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
        String name = scanner.nextLine();

        String race;
        boolean existingRace = false;
        do {
            System.out.println("Please, give valid race name of your character");
            race = scanner.nextLine();

            String response = RESTCaller.exists("https://www.dnd5eapi.co/api/races/%s".formatted(race));
            if (response != null && response.trim().equals("OK")) {
                existingRace = true;
            }
        } while (!existingRace);

        String classes;
        boolean existingClass = false;
        do {
            System.out.println("Please, give the class of your character");
            classes = scanner.nextLine();

            String response = RESTCaller.exists("https://www.dnd5eapi.co/api/classes/%s".formatted(classes));
            if (response != null && response.trim().equals("OK")) {
                existingClass = true;
            }
        } while (!existingClass);

        String responseSpells = RESTCaller.passContent("https://www.dnd5eapi.co/api/classes/%s/spellcasting"
                .formatted(classes));
        boolean spellsExist = responseSpells != null;
        if (spellsExist) {
            // TODO DEBUG INFO
            System.out.println(responseSpells);
            return;
        }

        String spell = "";
        if (spellsExist) {
            System.out.println("Please, select spells or/and cantrips of your character");
            spell = scanner.nextLine();
        }

        System.out.println("Please write background for your character");
        String background = scanner.nextLine();

        File file = new File("src\\main\\java\\org\\example\\" + name + ".txt");
        try {
            boolean created = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.flush();

            bufferedWriter.write("race: " + race);
            bufferedWriter.write("\n");
            bufferedWriter.write("class: " + classes);
            bufferedWriter.write(("\n"));
            //TODO user is able to select spells/cantrips if available (can be done via a list and number of the spell);
            bufferedWriter.write("spells or/and cantrips: " + spell);
            bufferedWriter.write(("\n"));
            bufferedWriter.write("background: " + background);
            bufferedWriter.write(("\n"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //TODO Everything has been tested properly. */
    }
}







