import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    @Test
    public void testConvertJSONClazz() {
        //given
        String name = "bard";
        String json = " {\n" +
                "    \"level\": 1,\n" +
                "    \"ability_score_bonuses\": 0,\n" +
                "    \"prof_bonus\": 2,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"fighter-fighting-style\",\n" +
                "        \"name\": \"Fighting Style\",\n" +
                "        \"url\": \"/api/features/fighter-fighting-style\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"index\": \"second-wind\",\n" +
                "        \"name\": \"Second Wind\",\n" +
                "        \"url\": \"/api/features/second-wind\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 0,\n" +
                "      \"indomitable_uses\": 0,\n" +
                "      \"extra_attacks\": 0\n" +
                "    },\n" +
                "    \"index\": \"fighter-1\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 2,\n" +
                "    \"ability_score_bonuses\": 0,\n" +
                "    \"prof_bonus\": 2,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"action-surge-1-use\",\n" +
                "        \"name\": \"Action Surge (1 use)\",\n" +
                "        \"url\": \"/api/features/action-surge-1-use\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 0,\n" +
                "      \"extra_attacks\": 0\n" +
                "    },\n" +
                "    \"index\": \"fighter-2\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/2\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 3,\n" +
                "    \"ability_score_bonuses\": 0,\n" +
                "    \"prof_bonus\": 2,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"martial-archetype\",\n" +
                "        \"name\": \"Martial Archetype\",\n" +
                "        \"url\": \"/api/features/martial-archetype\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 0,\n" +
                "      \"extra_attacks\": 0\n" +
                "    },\n" +
                "    \"index\": \"fighter-3\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 4,\n" +
                "    \"ability_score_bonuses\": 1,\n" +
                "    \"prof_bonus\": 2,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"fighter-ability-score-improvement-1\",\n" +
                "        \"name\": \"Ability Score Improvement\",\n" +
                "        \"url\": \"/api/features/fighter-ability-score-improvement-1\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 0,\n" +
                "      \"extra_attacks\": 0\n" +
                "    },\n" +
                "    \"index\": \"fighter-4\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/4\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 5,\n" +
                "    \"ability_score_bonuses\": 1,\n" +
                "    \"prof_bonus\": 3,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"extra-attack-1\",\n" +
                "        \"name\": \"Extra Attack\",\n" +
                "        \"url\": \"/api/features/extra-attack-1\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 0,\n" +
                "      \"extra_attacks\": 1\n" +
                "    },\n" +
                "    \"index\": \"fighter-5\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/5\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 6,\n" +
                "    \"ability_score_bonuses\": 2,\n" +
                "    \"prof_bonus\": 3,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"fighter-ability-score-improvement-2\",\n" +
                "        \"name\": \"Ability Score Improvement\",\n" +
                "        \"url\": \"/api/features/fighter-ability-score-improvement-2\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 0,\n" +
                "      \"extra_attacks\": 1\n" +
                "    },\n" +
                "    \"index\": \"fighter-6\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/6\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 7,\n" +
                "    \"ability_score_bonuses\": 2,\n" +
                "    \"prof_bonus\": 3,\n" +
                "    \"features\": [],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 0,\n" +
                "      \"extra_attacks\": 1\n" +
                "    },\n" +
                "    \"index\": \"fighter-7\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/7\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 8,\n" +
                "    \"ability_score_bonuses\": 3,\n" +
                "    \"prof_bonus\": 3,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"fighter-ability-score-improvement-3\",\n" +
                "        \"name\": \"Ability Score Improvement\",\n" +
                "        \"url\": \"/api/features/fighter-ability-score-improvement-3\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 0,\n" +
                "      \"extra_attacks\": 1\n" +
                "    },\n" +
                "    \"index\": \"fighter-8\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/8\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 9,\n" +
                "    \"ability_score_bonuses\": 3,\n" +
                "    \"prof_bonus\": 4,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"indomitable-1-use\",\n" +
                "        \"name\": \"Indomitable (1 use)\",\n" +
                "        \"url\": \"/api/features/indomitable-1-use\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 1,\n" +
                "      \"extra_attacks\": 1\n" +
                "    },\n" +
                "    \"index\": \"fighter-9\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/9\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 10,\n" +
                "    \"ability_score_bonuses\": 3,\n" +
                "    \"prof_bonus\": 4,\n" +
                "    \"features\": [],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 1,\n" +
                "      \"extra_attacks\": 1\n" +
                "    },\n" +
                "    \"index\": \"fighter-10\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/10\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 11,\n" +
                "    \"ability_score_bonuses\": 3,\n" +
                "    \"prof_bonus\": 4,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"extra-attack-2\",\n" +
                "        \"name\": \"Extra Attack (2)\",\n" +
                "        \"url\": \"/api/features/extra-attack-2\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 1,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-11\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/11\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 12,\n" +
                "    \"ability_score_bonuses\": 4,\n" +
                "    \"prof_bonus\": 4,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"fighter-ability-score-improvement-4\",\n" +
                "        \"name\": \"Ability Score Improvement\",\n" +
                "        \"url\": \"/api/features/fighter-ability-score-improvement-4\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 1,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-12\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/12\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 13,\n" +
                "    \"ability_score_bonuses\": 4,\n" +
                "    \"prof_bonus\": 5,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"indomitable-2-uses\",\n" +
                "        \"name\": \"Indomitable (2 uses)\",\n" +
                "        \"url\": \"/api/features/indomitable-2-uses\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 2,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-13\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/13\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 14,\n" +
                "    \"ability_score_bonuses\": 5,\n" +
                "    \"prof_bonus\": 5,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"fighter-ability-score-improvement-5\",\n" +
                "        \"name\": \"Ability Score Improvement\",\n" +
                "        \"url\": \"/api/features/fighter-ability-score-improvement-5\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 2,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-14\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/14\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 15,\n" +
                "    \"ability_score_bonuses\": 5,\n" +
                "    \"prof_bonus\": 5,\n" +
                "    \"features\": [],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 2,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-15\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/15\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 16,\n" +
                "    \"ability_score_bonuses\": 6,\n" +
                "    \"prof_bonus\": 5,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"fighter-ability-score-improvement-6\",\n" +
                "        \"name\": \"Ability Score Improvement\",\n" +
                "        \"url\": \"/api/features/fighter-ability-score-improvement-6\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 1,\n" +
                "      \"indomitable_uses\": 2,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-16\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/16\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 17,\n" +
                "    \"ability_score_bonuses\": 6,\n" +
                "    \"prof_bonus\": 6,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"action-surge-2-uses\",\n" +
                "        \"name\": \"Action Surge (2 uses)\",\n" +
                "        \"url\": \"/api/features/action-surge-2-uses\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"index\": \"indomitable-3-uses\",\n" +
                "        \"name\": \"Indomitable (3 uses)\",\n" +
                "        \"url\": \"/api/features/indomitable-3-uses\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 2,\n" +
                "      \"indomitable_uses\": 3,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-17\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/17\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 18,\n" +
                "    \"ability_score_bonuses\": 6,\n" +
                "    \"prof_bonus\": 6,\n" +
                "    \"features\": [],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 2,\n" +
                "      \"indomitable_uses\": 3,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-18\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/18\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 19,\n" +
                "    \"ability_score_bonuses\": 7,\n" +
                "    \"prof_bonus\": 6,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"fighter-ability-score-improvement-7\",\n" +
                "        \"name\": \"Ability Score Improvement\",\n" +
                "        \"url\": \"/api/features/fighter-ability-score-improvement-7\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 2,\n" +
                "      \"indomitable_uses\": 3,\n" +
                "      \"extra_attacks\": 2\n" +
                "    },\n" +
                "    \"index\": \"fighter-19\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/19\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"level\": 20,\n" +
                "    \"ability_score_bonuses\": 7,\n" +
                "    \"prof_bonus\": 6,\n" +
                "    \"features\": [\n" +
                "      {\n" +
                "        \"index\": \"extra-attack-3\",\n" +
                "        \"name\": \"Extra Attack (3)\",\n" +
                "        \"url\": \"/api/features/extra-attack-3\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"class_specific\": {\n" +
                "      \"action_surges\": 2,\n" +
                "      \"indomitable_uses\": 3,\n" +
                "      \"extra_attacks\": 3\n" +
                "    },\n" +
                "    \"index\": \"fighter-20\",\n" +
                "    \"class\": {\n" +
                "      \"index\": \"fighter\",\n" +
                "      \"name\": \"Fighter\",\n" +
                "      \"url\": \"/api/classes/fighter\"\n" +
                "    },\n" +
                "    \"url\": \"/api/classes/fighter/levels/20\"\n" +
                "  }";
        //when
        Clazz actual = ClazzMAPPER.convertJSON(json);
        //then
        Assertions.assertThrows(NullPointerException.class, () -> ClazzMAPPER.convertJSON(json));
    }

    @Test
    public void testConvertJSONAbilityBonusWithWhiteSigns() {
        //given
        String name = " bard ";
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
    @Test
    public void shootPassStartingEquipmentTest() {
        //given
        List<Item> testList = new ArrayList<>();
        Clazz instance = new Clazz();

        //when
        instance.setStartingEquipment(testList);
        List<Item> actual = instance.getStartingEquipment();

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }


}
