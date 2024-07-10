import org.example.AbilityBonus;
import org.example.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFeatures {
    @Test
    public void testConvertJSON(){
        //given
        String name = "Sarah";
        String json= "{\"name\": \""+name+"\"}";

        //when
        Feature actual = Feature.convertJSON(json);

        //then
        Assertions.assertEquals(name, actual.getName());
    }
    @Test
    public void testErroneusConvertJSONAbilityBonus(){
        //given
        String name = "Sarah";
        String json= "{\"name\": \""+name+"\"";
        //when
        Feature actual = Feature.convertJSON(json);
        //then
        Assertions.assertNull(actual);
    }

}
