package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String HappyPathJSON = "{\n" +
                "        \"index\": \"gnome\",\n" +
                "            \"name\": \"Gnome\",\n" +
                "            \"speed\": 25,\n" +
                "            \"ability_bonuses\": [\n" +
                "        {\n" +
                "            \"ability_score\": {\n" +
                "            \"index\": \"int\",\n" +
                "                    \"name\": \"INT\",\n" +
                "                    \"url\": \"/api/ability-scores/int\"\n" +
                "        },\n" +
                "            \"bonus\": 2\n" +
                "        }\n" +
                "  ],\n" +
                "        \"alignment\": \"Gnomes are most often good. Those who tend toward law are sages, engineers, researchers, scholars, investigators, or inventors. Those who tend toward chaos are minstrels, tricksters, wanderers, or fanciful jewelers. Gnomes are good-hearted, and even the tricksters among them are more playful than vicious.\",\n" +
                "            \"age\": \"Gnomes mature at the same rate humans do, and most are expected to settle down into an adult life by around age 40. They can live 350 to almost 500 years.\",\n" +
                "            \"size\": \"Small\",\n" +
                "            \"size_description\": \"Gnomes are between 3 and 4 feet tall and average about 40 pounds. Your size is Small.\",\n" +
                "            \"starting_proficiencies\": [],\n" +
                "        \"languages\": [\n" +
                "        {\n" +
                "            \"index\": \"common\",\n" +
                "                \"name\": \"Common\",\n" +
                "                \"url\": \"/api/languages/common\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"index\": \"gnomish\",\n" +
                "                \"name\": \"Gnomish\",\n" +
                "                \"url\": \"/api/languages/gnomish\"\n" +
                "        }\n" +
                "  ],\n" +
                "        \"language_desc\": \"You can speak, read, and write Common and Gnomish. The Gnomish language, which uses the Dwarvish script, is renowned for its technical treatises and its catalogs of knowledge about the natural world.\",\n" +
                "            \"traits\": [\n" +
                "        {\n" +
                "            \"index\": \"darkvision\",\n" +
                "                \"name\": \"Darkvision\",\n" +
                "                \"url\": \"/api/traits/darkvision\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"index\": \"gnome-cunning\",\n" +
                "                \"name\": \"Gnome Cunning\",\n" +
                "                \"url\": \"/api/traits/gnome-cunning\"\n" +
                "        }\n" +
                "  ],\n" +
                "        \"subraces\": [\n" +
                "        {\n" +
                "            \"index\": \"rock-gnome\",\n" +
                "                \"name\": \"Rock Gnome\",\n" +
                "                \"url\": \"/api/subraces/rock-gnome\"\n" +
                "        }\n" +
                "  ],\n" +
                "        \"url\": \"/api/races/gnome\"\n" +
                "    }";

        RaceMAPPER.convertJSON(HappyPathJSON);

     /*   Scanner scanner = new Scanner(System.in);
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
        //TODO Everything has been tested properly. */
    }
}







