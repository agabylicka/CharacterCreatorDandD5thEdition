package org.example;

import org.example.HTTP.*;
import org.example.MAPPERS.AllRacesMAPPER;
import org.example.MAPPERS.AllSpellsMAPPER;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        org.example.StandardClasses.Character character = new org.example.StandardClasses.Character();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, give the name of your character");
        String name = scanner.nextLine();
        character.setName(name);

        RaceInformation restInformation = new RaceInformation();
        String allRaces = null;
        String response1 = restInformation.getAllRaces();
        AllRacesResponse allRacesResponse = new AllRacesResponse();
        allRacesResponse = AllRacesMAPPER.convertJSON(response1);
        response1 = "";
        for (AllRacesResult result : allRacesResponse.getResults()) {
            response1 = response1 + result.getName() + ", ";
        }
        System.out.println("All races are: " + response1);

        String race;
        boolean existingRace = false;
        do {
            System.out.println("Please, give valid race name of your character");
            race = scanner.nextLine().trim().toLowerCase();

            HttpResponse response = restInformation.getRaceInformation(race);

            String body = response.body().toString();

            if (response != null && response.statusCode() == 200) {
                existingRace = true;
                character.setRace(race);
            }
        } while (!existingRace);

        ClassInformation classInformation = new ClassInformation();
        boolean existingCLass = false;
        do {
            System.out.println("Please, give valid class name of your character");
            String className = scanner.nextLine().trim().toLowerCase();

            HttpResponse response = classInformation.getClassInformation(className);
            if (response != null && response.statusCode() == 200) {
                existingCLass = true;
                character.setCharacterClass(className);
            }
        } while (!existingCLass);

        ClassSpells classSpells = new ClassSpells();
        String response12 = classSpells.getAllSpells();
        AllSpells allSpells1 = new AllSpells();
        allSpells1 = AllSpellsMAPPER.convertJSON(response12);
        response12 = "";
        for (AllSpellsResult result : allSpells1.getResults()) {
            response12 = response12 + result.getName() + ", ";
        }
        System.out.println("All spells are: " + response12);

        /*String spell;
        boolean existingSpell = false;
        do {
            // TODO change to multiple spells
            System.out.println("Please, select valid spell name of your character");
            spell = scanner.nextLine().trim().toLowerCase();

            HttpResponse response = restInformation.getRaceInformation(race);

            String body = response.body().toString();

            if (response != null && response.statusCode() == 200) {
                existingRace = true;
                character.setSpells(spell);
            } */


       /* System.out.println("Please write background for your character");
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







