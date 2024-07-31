import org.example.AbilityBonus;
import org.example.Race;
import org.example.RaceMAPPER;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRace {
    @Test
    public void testConvertJSONRace() {
        //given
        List<AbilityBonus> bonuses = new ArrayList<>();
        AbilityBonus bonus = new AbilityBonus();
        bonus.setName("block");
        bonus.setValue(1);
        bonuses.add(bonus);
        String bonusesAsString = "";
        for (AbilityBonus item : bonuses) {
            bonusesAsString += item + ",";
        }
        String languages = "common";
        String proficiencies = "bard";
        String size = "big";
        String json = "{" +
                "\"size\": \"" + size + "\"," +
                "\"speed\": \"" + 1 + "\"," +
                "\"languages\": [\"" + languages + "\"]," +
                "\"proficiencies\": [\"" + proficiencies + "\"]," +
                "\"bonuses\": [\"" + bonusesAsString + "\"]" +
                "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(size, actual.getSize());
    }

    /*@Test
    public void testConvertJSONRaceWithWhiteSigns() {
        //given
        String size = "                  big  ";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + 1 + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }



    @Test
    public void testConvertJSONRaceWithEmptyString() {
        //given
        String size = "";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + 1 + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(size, actual.getSize());
    } */

    @Test
    public void testConvertJSONRaceOnlyWithWhiteSigns() {
        //given
        String size = "\t \r \n";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + 1 + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    /*@Test
    public void testConvertJSONSpeed() {
        //given
        int speed = 100;
        String size = "big";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + speed + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(speed, actual.getSpeed());
    }

    @Test
    public void testConvertJSONWithMinusSpeed() {
        //given
        int speed = -5;
        String size = "big";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + speed + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(speed, actual.getSpeed());
    }

    @Test
    public void testConvertJSONWithMinusZero() {
        //given
        int speed = 0;
        String size = "big";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + speed + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals(speed, actual.getSpeed());
    } */

    @Test
    public void testErroneusConvertJSONRace() {
        //given
        String size = "big";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + 1 + "\"";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONRaceWithoutQuote() {
        //given
        String size = "big";
        String json = "{\size\": \"" + size + "\",\"speed\": \"" + 1 + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    /*@Test
    public void testErroneusConvertJSONRaceWithWrongSizeType() {
        //given
        String json = "{\"size\": " + 1 + ",\"speed\": \"" + 1 + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertEquals("1", actual.getSize());
    } */

    @Test
    public void testErroneusConvertJSONRaceWithSomething() {
        //given
        String json = "{\"size\": " + 1 + ",\"speed\": " + "something" + "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }
}
