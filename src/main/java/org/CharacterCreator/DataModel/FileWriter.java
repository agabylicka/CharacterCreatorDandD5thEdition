package org.CharacterCreator.DataModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {
     public String writeFile(String name, org.CharacterCreator.DataModel.Character character, String selection, String background) {
        File file = new File("src\\main\\java\\org\\CharacterCreator\\" + name + ".txt");

         java.io.FileWriter writer = null;
         BufferedWriter bufferedWriter = null;
        try {
            writer = new java.io.FileWriter(file); bufferedWriter = new BufferedWriter(writer);
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
        } finally {
            try {
                bufferedWriter.close();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
