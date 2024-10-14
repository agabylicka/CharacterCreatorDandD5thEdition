import org.CharacterCreator.DataModel.Race;
import org.CharacterCreator.MAPPERS.RaceMAPPER;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRace {
    @Test
    public void testConvertJSONRace() {
        //given
        String size = "Medium";
        String json = "{\n" +
                "  \"index\": \"dragonborn\",\n" +
                "  \"name\": \"Dragonborn\",\n" +
                "  \"speed\": 30,\n" +
                "  \"ability_bonuses\": [\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"str\",\n" +
                "        \"name\": \"STR\",\n" +
                "        \"url\": \"/api/ability-scores/str\"\n" +
                "      },\n" +
                "      \"bonus\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"cha\",\n" +
                "        \"name\": \"CHA\",\n" +
                "        \"url\": \"/api/ability-scores/cha\"\n" +
                "      },\n" +
                "      \"bonus\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"alignment\": \"Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil. Most dragonborn are good, but those who side with evil can be terrible villains.\",\n" +
                "  \"age\": \"Young dragonborn grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.\",\n" +
                "  \"size\": \"Medium\",\n" +
                "  \"size_description\": \"Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.\",\n" +
                "  \"starting_proficiencies\": [],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"index\": \"common\",\n" +
                "      \"name\": \"Common\",\n" +
                "      \"url\": \"/api/languages/common\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"draconic\",\n" +
                "      \"name\": \"Draconic\",\n" +
                "      \"url\": \"/api/languages/draconic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"language_desc\": \"You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.\",\n" +
                "  \"traits\": [\n" +
                "    {\n" +
                "      \"index\": \"draconic-ancestry\",\n" +
                "      \"name\": \"Draconic Ancestry\",\n" +
                "      \"url\": \"/api/traits/draconic-ancestry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"breath-weapon\",\n" +
                "      \"name\": \"Breath Weapon\",\n" +
                "      \"url\": \"/api/traits/breath-weapon\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"damage-resistance\",\n" +
                "      \"name\": \"Damage Resistance\",\n" +
                "      \"url\": \"/api/traits/damage-resistance\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subraces\": [],\n" +
                "  \"url\": \"/api/races/dragonborn\"\n" +
                "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual.getBonuses());
        Assertions.assertFalse(actual.getBonuses().isEmpty());
        Assertions.assertEquals(2, actual.getBonuses().size());
        Assertions.assertEquals(size, actual.getSize());

    }

    @Test
    public void testConvertJSONRaceWithWhiteSigns() {
        //given
        String json = "{\n" +
                "  \"index\": \"dragonborn\",\n" +
                "  \"name\": \"Dragonborn\",\n" +
                "  \"speed\": 30,\n" +
                "  \"ability_bonuses\": [\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"str\",\n" +
                "        \"name\": \"STR\",\n" +
                "        \"url\": \"/api/ability-scores/str\"\n" +
                "      },\n" +
                "      \"bonus\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"cha\",\n" +
                "        \"name\": \"CHA\",\n" +
                "        \"url\": \"/api/ability-scores/cha\"\n" +
                "      },\n" +
                "      \"bonus\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"alignment\": \"Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil. Most dragonborn are good, but those who side with evil can be terrible villains.\",\n" +
                "  \"age\": \"Young dragonborn grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.\",\n" +
                "  \"size\": \"    Medium\",\n" +
                "  \"size_description\": \"Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.\",\n" +
                "  \"starting_proficiencies\": [],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"index\": \"common\",\n" +
                "      \"name\": \"Common\",\n" +
                "      \"url\": \"/api/languages/common\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"draconic\",\n" +
                "      \"name\": \"Draconic\",\n" +
                "      \"url\": \"/api/languages/draconic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"language_desc\": \"You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.\",\n" +
                "  \"traits\": [\n" +
                "    {\n" +
                "      \"index\": \"draconic-ancestry\",\n" +
                "      \"name\": \"Draconic Ancestry\",\n" +
                "      \"url\": \"/api/traits/draconic-ancestry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"breath-weapon\",\n" +
                "      \"name\": \"Breath Weapon\",\n" +
                "      \"url\": \"/api/traits/breath-weapon\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"damage-resistance\",\n" +
                "      \"name\": \"Damage Resistance\",\n" +
                "      \"url\": \"/api/traits/damage-resistance\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subraces\": [],\n" +
                "  \"url\": \"/api/races/dragonborn\"\n" +
                "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals("    Medium", actual.getSize());
    }

    @Test
    public void testConvertJSONRaceWithEmptyString() {
        //given
        String size = "";
        String json = "{\n" +
                "  \"index\": \"dragonborn\",\n" +
                "  \"name\": \"Dragonborn\",\n" +
                "  \"speed\": 30,\n" +
                "  \"ability_bonuses\": [\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"str\",\n" +
                "        \"name\": \"STR\",\n" +
                "        \"url\": \"/api/ability-scores/str\"\n" +
                "      },\n" +
                "      \"bonus\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"cha\",\n" +
                "        \"name\": \"CHA\",\n" +
                "        \"url\": \"/api/ability-scores/cha\"\n" +
                "      },\n" +
                "      \"bonus\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"alignment\": \"Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil. Most dragonborn are good, but those who side with evil can be terrible villains.\",\n" +
                "  \"age\": \"Young dragonborn grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.\",\n" +
                "  \"size\": \"\",\n" +
                "  \"size_description\": \"Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.\",\n" +
                "  \"starting_proficiencies\": [],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"index\": \"common\",\n" +
                "      \"name\": \"Common\",\n" +
                "      \"url\": \"/api/languages/common\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"draconic\",\n" +
                "      \"name\": \"Draconic\",\n" +
                "      \"url\": \"/api/languages/draconic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"language_desc\": \"You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.\",\n" +
                "  \"traits\": [\n" +
                "    {\n" +
                "      \"index\": \"draconic-ancestry\",\n" +
                "      \"name\": \"Draconic Ancestry\",\n" +
                "      \"url\": \"/api/traits/draconic-ancestry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"breath-weapon\",\n" +
                "      \"name\": \"Breath Weapon\",\n" +
                "      \"url\": \"/api/traits/breath-weapon\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"damage-resistance\",\n" +
                "      \"name\": \"Damage Resistance\",\n" +
                "      \"url\": \"/api/traits/damage-resistance\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subraces\": [],\n" +
                "  \"url\": \"/api/races/dragonborn\"\n" +
                "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(size, actual.getSize());
    }

    @Test
    public void testConvertJSONRaceOnlyWithWhiteSignsResultNull() {
        //given
        String size = "\t \r \n";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + 1 + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testConvertJSONSpeed() {
        //given
        int speed = 100;
        String json = "{\n" +
                "  \"index\": \"dragonborn\",\n" +
                "  \"name\": \"Dragonborn\",\n" +
                "  \"speed\": 100,\n" +
                "  \"ability_bonuses\": [\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"str\",\n" +
                "        \"name\": \"STR\",\n" +
                "        \"url\": \"/api/ability-scores/str\"\n" +
                "      },\n" +
                "      \"bonus\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"cha\",\n" +
                "        \"name\": \"CHA\",\n" +
                "        \"url\": \"/api/ability-scores/cha\"\n" +
                "      },\n" +
                "      \"bonus\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"alignment\": \"Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil. Most dragonborn are good, but those who side with evil can be terrible villains.\",\n" +
                "  \"age\": \"Young dragonborn grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.\",\n" +
                "  \"size\": \"Medium\",\n" +
                "  \"size_description\": \"Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.\",\n" +
                "  \"starting_proficiencies\": [],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"index\": \"common\",\n" +
                "      \"name\": \"Common\",\n" +
                "      \"url\": \"/api/languages/common\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"draconic\",\n" +
                "      \"name\": \"Draconic\",\n" +
                "      \"url\": \"/api/languages/draconic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"language_desc\": \"You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.\",\n" +
                "  \"traits\": [\n" +
                "    {\n" +
                "      \"index\": \"draconic-ancestry\",\n" +
                "      \"name\": \"Draconic Ancestry\",\n" +
                "      \"url\": \"/api/traits/draconic-ancestry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"breath-weapon\",\n" +
                "      \"name\": \"Breath Weapon\",\n" +
                "      \"url\": \"/api/traits/breath-weapon\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"damage-resistance\",\n" +
                "      \"name\": \"Damage Resistance\",\n" +
                "      \"url\": \"/api/traits/damage-resistance\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subraces\": [],\n" +
                "  \"url\": \"/api/races/dragonborn\"\n" +
                "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(speed, actual.getSpeed());
    }

    @Test
    public void testConvertJSONWithMinusSpeed() {
        //given
        int speed = -5;
        String json = "{\n" +
                "  \"index\": \"dragonborn\",\n" +
                "  \"name\": \"Dragonborn\",\n" +
                "  \"speed\": -5,\n" +
                "  \"ability_bonuses\": [\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"str\",\n" +
                "        \"name\": \"STR\",\n" +
                "        \"url\": \"/api/ability-scores/str\"\n" +
                "      },\n" +
                "      \"bonus\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"cha\",\n" +
                "        \"name\": \"CHA\",\n" +
                "        \"url\": \"/api/ability-scores/cha\"\n" +
                "      },\n" +
                "      \"bonus\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"alignment\": \"Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil. Most dragonborn are good, but those who side with evil can be terrible villains.\",\n" +
                "  \"age\": \"Young dragonborn grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.\",\n" +
                "  \"size\": \"Medium\",\n" +
                "  \"size_description\": \"Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.\",\n" +
                "  \"starting_proficiencies\": [],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"index\": \"common\",\n" +
                "      \"name\": \"Common\",\n" +
                "      \"url\": \"/api/languages/common\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"draconic\",\n" +
                "      \"name\": \"Draconic\",\n" +
                "      \"url\": \"/api/languages/draconic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"language_desc\": \"You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.\",\n" +
                "  \"traits\": [\n" +
                "    {\n" +
                "      \"index\": \"draconic-ancestry\",\n" +
                "      \"name\": \"Draconic Ancestry\",\n" +
                "      \"url\": \"/api/traits/draconic-ancestry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"breath-weapon\",\n" +
                "      \"name\": \"Breath Weapon\",\n" +
                "      \"url\": \"/api/traits/breath-weapon\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"damage-resistance\",\n" +
                "      \"name\": \"Damage Resistance\",\n" +
                "      \"url\": \"/api/traits/damage-resistance\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subraces\": [],\n" +
                "  \"url\": \"/api/races/dragonborn\"\n" +
                "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(speed, actual.getSpeed());
    }

    @Test
    public void testConvertJSONWithZero() {
        //given
        int speed = 0;
        String json = "{\n" +
                "  \"index\": \"dragonborn\",\n" +
                "  \"name\": \"Dragonborn\",\n" +
                "  \"speed\": 0,\n" +
                "  \"ability_bonuses\": [\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"str\",\n" +
                "        \"name\": \"STR\",\n" +
                "        \"url\": \"/api/ability-scores/str\"\n" +
                "      },\n" +
                "      \"bonus\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"cha\",\n" +
                "        \"name\": \"CHA\",\n" +
                "        \"url\": \"/api/ability-scores/cha\"\n" +
                "      },\n" +
                "      \"bonus\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"alignment\": \"Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil. Most dragonborn are good, but those who side with evil can be terrible villains.\",\n" +
                "  \"age\": \"Young dragonborn grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.\",\n" +
                "  \"size\": \"Medium\",\n" +
                "  \"size_description\": \"Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.\",\n" +
                "  \"starting_proficiencies\": [],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"index\": \"common\",\n" +
                "      \"name\": \"Common\",\n" +
                "      \"url\": \"/api/languages/common\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"draconic\",\n" +
                "      \"name\": \"Draconic\",\n" +
                "      \"url\": \"/api/languages/draconic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"language_desc\": \"You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.\",\n" +
                "  \"traits\": [\n" +
                "    {\n" +
                "      \"index\": \"draconic-ancestry\",\n" +
                "      \"name\": \"Draconic Ancestry\",\n" +
                "      \"url\": \"/api/traits/draconic-ancestry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"breath-weapon\",\n" +
                "      \"name\": \"Breath Weapon\",\n" +
                "      \"url\": \"/api/traits/breath-weapon\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"damage-resistance\",\n" +
                "      \"name\": \"Damage Resistance\",\n" +
                "      \"url\": \"/api/traits/damage-resistance\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subraces\": [],\n" +
                "  \"url\": \"/api/races/dragonborn\"\n" +
                "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(speed, actual.getSpeed());
    }

    @Test
    public void testErroneusConvertJSONRaceWithResultNull() {
        //given
        String size = "big";
        String json = "{\"size\": \"" + size + "\",\"speed\": \"" + 1 + "\"";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONRaceWithoutQuoteWithResultNull() {
        //given
        String size = "big";
        String json = "{\size\": \"" + size + "\",\"speed\": \"" + 1 + "\"}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testErroneusConvertJSONRaceWithSomethingWithResultNull() {
        //given
        String json = "{\"size\": " + 1 + ",\"speed\": " + "something" + "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

    @Test
    public void testConvertJSONRaceWithStartingProficiencies() {
        //given
        String size = "Medium";
        String json = "{\n" +
                "  \"index\": \"dragonborn\",\n" +
                "  \"name\": \"Dragonborn\",\n" +
                "  \"speed\": 30,\n" +
                "  \"ability_bonuses\": [\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"str\",\n" +
                "        \"name\": \"STR\",\n" +
                "        \"url\": \"/api/ability-scores/str\"\n" +
                "      },\n" +
                "      \"bonus\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"ability_score\": {\n" +
                "        \"index\": \"cha\",\n" +
                "        \"name\": \"CHA\",\n" +
                "        \"url\": \"/api/ability-scores/cha\"\n" +
                "      },\n" +
                "      \"bonus\": 1\n" +
                "    }\n" +
                "  ],\n" +
                "  \"alignment\": \"Dragonborn tend to extremes, making a conscious choice for one side or the other in the cosmic war between good and evil. Most dragonborn are good, but those who side with evil can be terrible villains.\",\n" +
                "  \"age\": \"Young dragonborn grow quickly. They walk hours after hatching, attain the size and development of a 10-year-old human child by the age of 3, and reach adulthood by 15. They live to be around 80.\",\n" +
                "  \"size\": \"Medium\",\n" +
                "  \"size_description\": \"Dragonborn are taller and heavier than humans, standing well over 6 feet tall and averaging almost 250 pounds. Your size is Medium.\",\n" +
                "  \"starting_proficiencies\": [\"killing_dragons\"],\n" +
                "  \"languages\": [\n" +
                "    {\n" +
                "      \"index\": \"common\",\n" +
                "      \"name\": \"Common\",\n" +
                "      \"url\": \"/api/languages/common\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"draconic\",\n" +
                "      \"name\": \"Draconic\",\n" +
                "      \"url\": \"/api/languages/draconic\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"language_desc\": \"You can speak, read, and write Common and Draconic. Draconic is thought to be one of the oldest languages and is often used in the study of magic. The language sounds harsh to most other creatures and includes numerous hard consonants and sibilants.\",\n" +
                "  \"traits\": [\n" +
                "    {\n" +
                "      \"index\": \"draconic-ancestry\",\n" +
                "      \"name\": \"Draconic Ancestry\",\n" +
                "      \"url\": \"/api/traits/draconic-ancestry\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"breath-weapon\",\n" +
                "      \"name\": \"Breath Weapon\",\n" +
                "      \"url\": \"/api/traits/breath-weapon\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"index\": \"damage-resistance\",\n" +
                "      \"name\": \"Damage Resistance\",\n" +
                "      \"url\": \"/api/traits/damage-resistance\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"subraces\": [],\n" +
                "  \"url\": \"/api/races/dragonborn\"\n" +
                "}";
        //when
        Race actual = RaceMAPPER.convertJSON(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(size, actual.getSize());
    }
}
