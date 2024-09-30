package org.CharacterCreator;

import org.CharacterCreator.DataModel.Spells;
import org.CharacterCreator.HTTP.*;
import org.CharacterCreator.MAPPERS.SpellsMAPPER;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        org.CharacterCreator.DataModel.Character character = new org.CharacterCreator.DataModel.Character();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, give the name of your character");
        String name = scanner.nextLine();
        character.setName(name);

        System.out.println("All races are: dragonborn, dwarf, elf, gnome, half-elf, half-orc, halfling, human, tiefling");



       /* RaceInformation restInformation = new RaceInformation();
        String allRaces = null;
        String response1 = restInformation.getAllRaces();
        AllRacesResponse allRacesResponse = new AllRacesResponse();
        allRacesResponse = AllRacesMAPPER.convertJSON(response1);
        response1 = "";
        for (AllRacesResult result : allRacesResponse.getResults()) {
            response1 = response1 + result.getName() + ", ";
        }
        System.out.println("All races are: " + response1); */

        String race;
        boolean existingRace = false;
        do {
            System.out.println("Please, give valid race name of your character");
            race = scanner.nextLine().trim().toLowerCase();

            //HttpResponse response = restInformation.getRaceInformation(race);

            //String body = response.body().toString();

            if (race.equals("dragonborn") || race.equals("dwarf") || race.equals("elf") || race.equals("gnome")
                    || race.equals("half-elf") || race.equals("half-orc") || race.equals("halfling")
                    || race.equals("human") || race.equals("tiefling")) {
                existingRace = true;
                character.setRace(race);
            }
        } while (!existingRace);

        //ClassInformation classInformation = new ClassInformation();
        boolean existingCLass = false;
        String className;

        System.out.println("All races are: barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue, sorcerer, warlock, wizard");
        do {
            System.out.println("Please, give valid class name of your character");
            className = scanner.nextLine().trim().toLowerCase();

            //HttpResponse response = classInformation.getClassInformation(className);
            if (className.equals("barbarian") || className.equals("bard") || className.equals("cleric")
                    || className.equals("druid") || className.equals("fighter") || className.equals("monk")
                    || className.equals("paladin") || className.equals("ranger") || className.equals("rogue")
                    || className.equals("sorcerer") || className.equals("warlock") || className.equals("wizard") ) {
                existingCLass = true;
                character.setCharacterClass(className);
            }
        } while (!existingCLass);

//TODO finish spells
        ClassSpells classSpells = new ClassSpells();
        HttpResponse<String> response12 = classSpells.getClassSpells(className);
        List<AllSpellsResult> spells = SpellsMAPPER.convertJSONToListOfSpells(response12.body());
        String allSpellsNames = "";
        for (var spell : spells) {
            allSpellsNames += spell.getName() + ", ";
        }
        System.out.println("Available spells for this class are: " + allSpellsNames);

        boolean foundSpell;
        String selection = null;
        do {
            System.out.println("Which spell do You choose?");
            selection = scanner.nextLine();
            foundSpell = allSpellsNames.contains(selection.trim());
        } while (!foundSpell);

        for (AllSpellsResult spell : spells) {
            if (spell.getName().equals(selection)) {
                Spells named = new Spells();
                named.setName(spell.getName());
                character.setSpells(List.of(named));
                break;
            }
        }

        System.out.println("Please write background for your character");
        String background = scanner.nextLine();
        // C:\Users\kwazi\Documents\NetBeansProjects\CharacterCreatorDandD5thEdition\src\main\java\org\CharacterCreator
        File file = new File("src\\main\\java\\org\\CharacterCreator\\" + name + ".txt");
        try {
            boolean created = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.flush();
            bufferedWriter.write("name: " + character.getName());
            bufferedWriter.newLine();
            bufferedWriter.write("race: " + character.getRace());
            bufferedWriter.write("\n");
            bufferedWriter.write("class: " + character.getCharacterClass());
            bufferedWriter.write(("\n"));
            bufferedWriter.write("spells or/and cantrips: " + selection);
            bufferedWriter.write(("\n"));
            bufferedWriter.write("background: " + background);
            bufferedWriter.write(("\n"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //TODO Everything has been tested properly. */
    }
}








