package org.CharacterCreator.DataModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileToWrite {
     public String writeFile(String name, Character character, String selection, String background) {
        File file = new File("src\\main\\java\\org\\CharacterCreator\\" + name + ".txt");
        try (FileWriter writer = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write("Name: " + character.getName());
            bufferedWriter.newLine();
            bufferedWriter.write("Race: " + character.getRace());
            bufferedWriter.newLine();
            bufferedWriter.write("Class: " + character.getCharacterClass());
            bufferedWriter.newLine();
            bufferedWriter.write("Spells or/and cantrips: " + selection);
            bufferedWriter.newLine();
            bufferedWriter.write("Background: " + background);
            bufferedWriter.newLine();
            bufferedWriter.write("You are on level 1.");
            bufferedWriter.newLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return "OK";
    }

    public boolean removeFile(String name) {
         File file = null;
         boolean result = false;
         try { file = new File("src\\main\\java\\org\\CharacterCreator\\" + name + ".txt");
            result = file.delete();
        } catch (Exception e) {
            return false;
        }
        return result;
     }
}