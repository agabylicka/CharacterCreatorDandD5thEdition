import org.example.AbilityBonus;
import org.example.AbilityBonusMAPPER;
import org.example.SpellsMAPPER;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestAbilityBonus {
    @Test
    public void testConvertJSONAbilityBonus() {
        //given
        String name = "Charisma";
        String json = "{\"name\": \"" + name + "\",\"value\": \"" + 1 + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONAbilityBonusWithWhiteSigns() {
        //given
        String name = " Charisma  ";
        String json = "{\"name\": \"" + name + "\",\"value\": \"" + 1 + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONAbilityBonusWithEmptyString() {
        //given
        String name = "";
        String json = "{\"name\": \"" + name + "\",\"value\": \"" + 1 + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(name, actual.getName());
    }

    @Test
    public void testConvertJSONAbilityBonusOnlyWithWhiteSigns() {
        //given
        String name = "\t \r \n";
        String json = "{\"name\": \"" + name + "\",\"value\": \"" + 1 + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testConvertJSONValue() {
        //given
        int value = 1;
        String name = "Charisma";
        String json = "{\"name\": \"" + name + "\",\"value\": \"" + value + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(value, actual.getValue());
    }

    @Test
    public void testConvertJSONWithoutName() {
        //given
        int value = 1;
        String name = "Charisma";
        String json = "{\"value\": \"" + value + "\"}";
        //then
        assertThrows(NullPointerException.class, () -> AbilityBonusMAPPER.convertJSON(json));
    }

    @Test
    public void testConvertJSONWithATypoInTheValue() {
        //given
        int value = 1;
        String name = "Charisma";
        String json = "{\"name\": \"" + name + "\",\"vaue\": \"" + value + "\"}";
        //when
        assertThrows(NullPointerException.class, () -> AbilityBonusMAPPER.convertJSON(json));
    }

    @Test
    public void testConvertJSONWithMinusValue() {
        //given
        int value = -1;
        String name = "Charisma";
        String json = "{\"name\": \"" + name + "\",\"value\": \"" + value + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(value, actual.getValue());
    }

    @Test
    public void testConvertJSONWithMinusZero() {
        //given
        int value = 0;
        String name = "Charisma";
        String json = "{\"name\": \"" + name + "\",\"value\": \"" + value + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(value, actual.getValue());
    }

    @Test
    public void testErroneusConvertJSONAbilityBonus() {
        //given
        String name = "Charisma";
        String json = "{\"name\": \"" + name + "\",\"value\": \"" + 1 + "\"";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONAbilityBonusWithoutQuote() {
        //given
        String name = "Charisma";
        String json = "{\name\": \"" + name + "\",\"value\": \"" + 1 + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONAbilityBonusWithWrongNameType() {
        //given
        String json = "{\"name\": " + 1 + ",\"value\": \"" + 1 + "\"}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals("1", actual.getName());
    }

    @Test
    public void testErroneusConvertJSONAbilityBonusWithSomething() {
        //given
        String json = "{\"name\": " + 1 + ",\"value\": " + "something" + "}";
        //when
        AbilityBonus actual = AbilityBonusMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }
}
