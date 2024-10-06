import org.CharacterCreator.DataModel.Spells;
import org.CharacterCreator.MAPPERS.SpellsMAPPER;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;


class SpellsMAPPERTest {

    @Test
    public void testConvertJSONASpells() {
        //given
        String name = "alarm";
        String json = readFile("spells_wizard_level_1_response.json");
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(actual.getName().contains(name));
    }

    @Test
    public void testConvertJSONSpellsWithWhiteSigns() {
        // given
        String name = " alarm  ";
        String json = readFile("spells_wizard_level_1_response.json");
        // when
        Spells actual = SpellsMAPPER.convertJSON(json);
        // then
        Assertions.assertNotNull(actual);
        Assertions.assertFalse(actual.getName().contains(name));
    }

    @Test
    public void testConvertJSONSpellsWithEmptyString() {
        //given
        String name = "";
        String json = readFile("spells_wizard_level_1_response.json");
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertNotEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONSpellsOnlyWithWhiteSigns() {
        //given
        String json = "{\"name\": \"\t \n \n\"}";
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONSpellsWithWrongNameType() {
        //given
        String json = "{\"nname\": \"illusion\"}";
        Exception thrown = null;
        assertThrows(NullPointerException.class, () -> SpellsMAPPER.convertJSON(json));
    }

    @Test
    public void testErroneusConvertJSONSpellsWithSlash() {
        //given
        String json = "{\"name\": \\ }";
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

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

    public String readFile(String fileName) {
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