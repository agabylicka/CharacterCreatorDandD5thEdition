import org.example.Proficiencies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestProficiencies {
    @Test
    public void testProficiencies() {
        String index = "elf";
        Proficiencies proficiencies = new Proficiencies();
        HttpResponse<String> actual = proficiencies.getProficiencies(index);
        Assertions.assertEquals(200, actual.statusCode());
    }

    @Test
    public void testNullClassProficiencies() {
        String index = null;
        Proficiencies proficiencies = new Proficiencies();
        Exception thrown = null;

        HttpResponse<String> actual = null;
        try {
            actual = proficiencies.getProficiencies(index);
        } catch (RuntimeException occurred) {
            thrown = occurred;
        }
        Assertions.assertNotNull(thrown);
        Assertions.assertEquals(null, actual);
    }

    @Test
    public void testUnhappyClassProficiencies() {
        String index = "";
        Proficiencies proficiencies = new Proficiencies();

        HttpResponse<String> actual = proficiencies.getProficiencies(index);
        Assertions.assertEquals(404, actual.statusCode());
    }

    @Test
    public void testNotExistingClassEqualsZeroResult() {
        String index = "Non_existing";
        Proficiencies proficiencies = new Proficiencies();
        String expected = "{\"count\":0,\"results\":[]}";

        HttpResponse<String> actual = proficiencies.getProficiencies(index);
        Assertions.assertEquals(200, actual.statusCode());
        Assertions.assertEquals(expected, actual.body());
    }
}
