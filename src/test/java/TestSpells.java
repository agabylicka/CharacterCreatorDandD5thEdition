import org.example.Spells;
import org.example.SpellsMAPPER;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestSpells {
    @Test
    public void testConvertJSONASpells() {
        //given
        String name = "illusion";
        String json = "{\"name\": \"" + name + "\"}";
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONSpellsWithWhiteSigns() {
        //given
        String name = " illusion  ";
        String json = "{\"name\": \"" + name + "\"}";
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONSpellsWithEmptyString() {
        //given
        String name = "";
        String json = "{\"name\": \"" + name + "\"}";
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONSpellsOnlyWithWhiteSigns() {
        //given
        String name = "\t \r \n";
        String json = "{\"name\": \"" + name + "\"}";
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusInvalidJSONSpells() {
        //given
        String json = "{\"name: \"illusion\"}";
        //when
        Spells actual = SpellsMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONSpellsWithWrongNameType() {
        //given
        String name = "illusion";
        String json = "{\"nname\": \"" + name + "\"}";
        Exception thrown = null;
        //when
            /*Spells actual = null;
            try {
                actual = SpellsMAPPER.convertJSON(json);
            } catch (Exception occurred) {
                thrown = occurred;
            }
            //then
            Assertions.assertNotNull(thrown);
            Assertions.assertNull(actual); */
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
}
