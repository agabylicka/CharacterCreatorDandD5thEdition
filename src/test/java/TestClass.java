import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    @Test
    public void StartingEquipmentIsNotNullTest() {
        //given
        List<Item> testList = new ArrayList<>();
        CharacterClass instance = new CharacterClass();

        //when
        instance.setStartingEquipment(testList);
        List<Item> actual = instance.getStartingEquipment();

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testList, actual);
    }

    @Test
    public void PassProficienciesTest() {
        //given
        List<String> testProficiencies = new ArrayList<>();
        CharacterClass proficiencies = new CharacterClass();

        //when
        proficiencies.setProficiencies(testProficiencies);
        List<String> actual = proficiencies.getProficiencies();

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testProficiencies, actual);
    }

    @Test
    public void PassAvailableSkills() {
        //given
        List<String> testAvailableSkills = new ArrayList<>();
        CharacterClass availableSkills = new CharacterClass();

        //when
        availableSkills.setAvailableSkills((testAvailableSkills));
        List<String> actual = availableSkills.getAvailableSkills();

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testAvailableSkills, actual);
    }

    @Test
    public void testConvertJSONWithProficiency(){
        //given
        String proficiency = "bard";
        String json= "{ " +
                "\"proficiencies\" : [\"" + proficiency + "\"]," +
                "\"available_skills\": [], " +
                "\"starting_equipment\": []}";

        //when
        CharacterClass actual = CharacterClassMAPPER.convertJSON(json);

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertNotNull(actual.getProficiencies());
        Assertions.assertTrue(actual.getProficiencies().contains(proficiency));
    }

    @Test
    public void testConvertJSONWithAvailableSkills(){
        //given
        String available_skill = "lockpick";
        String json= "{ " +
                "\"proficiencies\": [], " +
                "\"available_skills\" : [\"" + available_skill + "\"]," +
                "\"starting_equipment\": []}";

        //when
        CharacterClass actual = CharacterClassMAPPER.convertJSON(json);

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertNotNull(actual.getAvailableSkills());
        Assertions.assertTrue(actual.getAvailableSkills().contains(available_skill));
    }

    @Test
    public void testConvertJSONWithStartingEquipment(){
        //given
        Item tool = new Item();
        tool.setName("rope");
        tool.setQuantity(1);
        String json= "{ " +
                "\"proficiencies\": [], " +
                "\"starting_equipment\" : [" + tool.toString() + "]," +
                "\"available_skills\": []}";

        //when
        CharacterClass actual = CharacterClassMAPPER.convertJSON(json);

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertNotNull(actual.getStartingEquipment());
        Assertions.assertFalse(actual.getStartingEquipment().isEmpty());
        Assertions.assertEquals(tool.toString(), actual.getStartingEquipment().get(0).toString());
    }
}
