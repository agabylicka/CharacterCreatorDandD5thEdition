package org.CharacterCreator.MAPPERS;

import org.CharacterCreator.DataModel.Spells;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


class SpellsMAPPERTest {

    @Test
    void testConvertJSON() {
        // given
        String json = readFile("spells_wizard_level_1_response.json");
        // when
        Spells actual = SpellsMAPPER.convertJSON(json);

        // then
        Assertions.assertNotNull(actual);
        Assertions.assertFalse(actual.getName().isEmpty());

    }

    String readFile(String fileName) {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());

            FileReader fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line = "";

            while (line != null) {
                line = reader.readLine();
                result.append(line);
            }
        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result.toString();
    }
}