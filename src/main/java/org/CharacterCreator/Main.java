package org.CharacterCreator;

import org.CharacterCreator.DataModel.Spells;
import org.CharacterCreator.HTTP.*;
import org.CharacterCreator.MAPPERS.AllRacesMAPPER;
import org.CharacterCreator.MAPPERS.SpellsByClassMAPPER;
import org.CharacterCreator.MAPPERS.SpellsMAPPER;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
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
        //SpellsByClassMAPPER spellsByClassMAPPER = new SpellsByClassMAPPER();
        SpellsMAPPER spellsMAPPER = new SpellsMAPPER();
        Spells spells = SpellsMAPPER.convertJSON(response12.body());
        String response13 = "";
        //for (Spellcasting_ability result : spellsByClass.getSpellcasting_ability()) {
           // response13 = response13 + result.getName() + ", ";
        //} */
        //}
        //System.out.println("All spells are: " + response13);
        //System.out.println("All spells are: " + spells);

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


        System.out.println("Please write background for your character");
        String background = scanner.nextLine();
//TODO check the filepath!
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
            bufferedWriter.write("class: " + className);
            bufferedWriter.write(("\n"));
            //TODO user is able to select spells if available (can be done via a list and number of the spell);
            //bufferedWriter.write("spells or/and cantrips: " + spell);
            bufferedWriter.write(("\n"));
            bufferedWriter.write("background: " + background);
            bufferedWriter.write(("\n"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //TODO Everything has been tested properly. */
    }
}








