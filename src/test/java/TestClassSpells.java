import org.example.ClassFeatures;
import org.example.ClassSpells;
import org.example.Proficiencies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassSpells {
        @Test
        public void testClassSpells() {
            String index = "bard";
            ClassSpells classSpells = new ClassSpells();
            //String expected = "Bane";
            HttpResponse<String> actual = classSpells.getClassSpells(index);
            //Assertions.assertTrue(actual.body().contains(expected));
            Assertions.assertEquals(200, actual.statusCode());
        }

    @Test
    public void testNullClassFeatures() {
        String index = null;
        ClassSpells classSpells = new ClassSpells();
        Exception thrown = null;

        HttpResponse<String> actual = null;
        try {
            actual = classSpells.getClassSpells(index);
        } catch (RuntimeException occurred) {
            thrown = occurred;
        }
        Assertions.assertNotNull(thrown);
        Assertions.assertEquals(null, actual);
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
