import org.example.AbilityBonus;
import org.example.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAbilityBonus {
    @Test
    public void testConvertJSONAbilityBonus(){
        //given
        String name = "Charisma";
        String json= "{\"name\": \""+name+"\",\"value\": \""+ 1 +"\"}";
        //when
        AbilityBonus actual = AbilityBonus.convertJSON(json);
        //then
        Assertions.assertEquals(name, actual.getName());
    }
    @Test
    public void testConvertJSONValue(){
        //given
        int value = 1;
        String name = "Charisma";
        String json= "{\"name\": \""+name+"\",\"value\": \""+ value +"\"}";
        //when
        AbilityBonus actual = AbilityBonus.convertJSON(json);
        //then
        Assertions.assertEquals(value, actual.getValue());

    }
    @Test
    public void testErroneusConvertJSONAbilityBonus(){
        //given
        String name = "Charisma";
        String json= "{\"name\": \""+name+"\",\"value\": \""+ 1 +"\"";
        //when
        AbilityBonus actual = AbilityBonus.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }
}

