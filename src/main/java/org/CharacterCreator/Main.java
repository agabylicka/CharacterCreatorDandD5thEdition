package org.CharacterCreator;

import org.CharacterCreator.DataModel.Spells;
import org.CharacterCreator.HTTP.*;
import org.CharacterCreator.MAPPERS.SpellsMAPPER;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
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
        ArrayList<String>raceRespond = new ArrayList<>();
        raceRespond.add("dragonborn");
        raceRespond.add("dwarf");
        raceRespond.add("elf");
        raceRespond.add("gnome");
        raceRespond.add("half-elf");
        raceRespond.add("half-orc");
        raceRespond.add("halfling");
        raceRespond.add("human");
        raceRespond.add("tiefling");

        String race;
        boolean existingRace = false;
        do {
            System.out.println("Please, give valid race name of your character");
            race = scanner.nextLine().trim().toLowerCase();


            if (raceRespond.contains(race)) {
                existingRace = true;
                character.setRace(race);
            }
        } while (!existingRace);

        boolean existingCLass = false;
        String className;

        System.out.println("All races are: barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue, sorcerer, warlock, wizard");
        ArrayList<String>classRespond = new ArrayList<>();
        classRespond.add("barbarian");
        classRespond.add("bard");
        classRespond.add("cleric");
        classRespond.add("druid");
        classRespond.add("fighter");
        classRespond.add("monk");
        classRespond.add("paladin");
        classRespond.add("ranger");
        classRespond.add("rogue");
        classRespond.add("sorcerer");
        classRespond.add("warlock");
        classRespond.add("wizard");
        do {
            System.out.println("Please, give valid class name of your character");
            className = scanner.nextLine().trim().toLowerCase();
            if (classRespond.contains(className)) {
                existingCLass = true;
                character.setCharacterClass(className);
            }
        } while (!existingCLass);

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

        File file = new File("src\\main\\java\\org\\CharacterCreator\\" + name + ".txt");

        try (FileWriter writer = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.flush();
            bufferedWriter.write("Name: " + character.getName());
            bufferedWriter.newLine();
            bufferedWriter.write("Race: " + character.getRace());
            bufferedWriter.write("\n");
            bufferedWriter.write("Class: " + character.getCharacterClass());
            bufferedWriter.write(("\n"));
            bufferedWriter.write("Spells or/and cantrips: " + selection);
            bufferedWriter.write(("\n"));
            bufferedWriter.write("Background: " + background);
            bufferedWriter.write(("\n"));
            bufferedWriter.write("You are on level 1.");
            bufferedWriter.write(("\n"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //TODO Everything has been tested properly. */
    }
}








