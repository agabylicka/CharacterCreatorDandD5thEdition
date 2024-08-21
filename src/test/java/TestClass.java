import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

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

    @Test
    public void PassProficienciesTest() {
        //given
        List<String> testProficiencies = new ArrayList<>();
        Clazz proficiencies = new Clazz();

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
        Clazz availableSkills = new Clazz();

        //when
        availableSkills.setAvailableSkills((testAvailableSkills));
        List<String> actual = availableSkills.getAvailableSkills();

        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(testAvailableSkills, actual);
    }

}
