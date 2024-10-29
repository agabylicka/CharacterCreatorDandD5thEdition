package org.CharacterCreator;

import org.CharacterCreator.DataModel.CharacterClass;
import org.CharacterCreator.DataModel.FileToWrite;
import org.CharacterCreator.DataModel.Race;
import org.CharacterCreator.DataModel.Spells;
import org.CharacterCreator.HTTP.ClassInformation;
import org.CharacterCreator.HTTP.ClassSpells;
import org.CharacterCreator.HTTP.RaceInformation;
import org.CharacterCreator.MAPPERS.SpellsMAPPER;

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
        ArrayList<String> raceRespond = new ArrayList<>();
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
                RaceInformation raceInformation = new RaceInformation();
                Race race1 = null;
                race1 = raceInformation.getRaceInformation(race);
                existingRace = true;
                character.setRace(race1);
            }
        } while (!existingRace);

        boolean existingCLass = false;
        String className;

        System.out.println("All classes are: barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue, sorcerer, warlock, wizard");
        ArrayList<String> classRespond = new ArrayList<>();
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
                ClassInformation classInformation = new ClassInformation();
                CharacterClass character1 = null;
                character1 = classInformation.getClassInformation(className);
                existingCLass = true;
                character.setCharacterClass(character1);
            }
        } while (!existingCLass);

        ClassSpells classSpells = new ClassSpells();
        HttpResponse<String> response12 = classSpells.getClassSpells(className);
        List<Spells> spells = SpellsMAPPER.convertJSONToListOfSpells(response12.body());
        String allSpellsNames = "";
        for (Spells spell : spells) {
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

        for (Spells spell : spells) {
            if (spell.getName().equals(selection)) {
                Spells named = new Spells();
                named.setName(spell.getName());
                character.setSpells(List.of(named));
                break;
            }
        }

        System.out.println("Please write background for your character");
        String background = scanner.nextLine();

        FileToWrite fileToWrite = new FileToWrite();
        fileToWrite.writeFile(name, selection, background, className, race);
    }
}