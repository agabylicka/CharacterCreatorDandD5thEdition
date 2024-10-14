import org.CharacterCreator.HTTP.ClassSpells;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassSpells {
    @Test
    public void testClassSpells() {
        String index = "bard";
        ClassSpells classSpells = new ClassSpells();
        HttpResponse<String> actual = classSpells.getClassSpells(index);
        Assertions.assertEquals(200, actual.statusCode());
    }

    @Test
    public void testNullClassFeatures() {
        String index = null;
        ClassSpells classSpells = new ClassSpells();
        Assertions.assertThrows(RuntimeException.class, () -> classSpells.getClassSpells(index));
    }

    @Test
    public void testUnhappyClassFeatures() {
        String index = "";
        ClassSpells classSpells = new ClassSpells();

        HttpResponse<String> actual = classSpells.getClassSpells(index);
        Assertions.assertEquals(404, actual.statusCode());
    }

    @Test
    public void testNotExistingClassEqualsZeroResult() {
        String index = "Non_existing";
        ClassSpells classSpells = new ClassSpells();
        String expected = "{\"count\":0,\"results\":[]}";

        HttpResponse<String> actual = classSpells.getClassSpells(index);
        Assertions.assertEquals(200, actual.statusCode());
        Assertions.assertEquals(expected, actual.body());
    }
}
