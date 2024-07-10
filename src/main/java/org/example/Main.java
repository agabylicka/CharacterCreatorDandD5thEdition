package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClassSpells classSpells = new ClassSpells();
        System.out.println(classSpells.getClassSpells("wizard"));
        HttpResponse<String> response3 = classSpells.getClassSpells("wizard");
        System.out.println(response3.statusCode());
        System.out.println(response3.body());
        System.out.println(response3.headers());

        Proficiencies proficiencies = new Proficiencies();
        System.out.println(proficiencies.getProficiencies("elf"));
        HttpResponse<String> response4 = proficiencies.getProficiencies("elf");
        System.out.println(response4.statusCode());
        System.out.println(response4.body());
        System.out.println(response4.headers());

        RaceInformation raceInformation = new RaceInformation();
        System.out.println(raceInformation.getRaceInformation("elf"));
        HttpResponse<String> response5 = raceInformation.getRaceInformation("elf");
        System.out.println(response5.statusCode());
        System.out.println(response5.body());
        System.out.println(response5.headers());

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
        //TODO Everything has been tested properly.
    }
}







