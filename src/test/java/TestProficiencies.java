import org.example.HTTP.Proficiencies;
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
        Assertions.assertThrows(RuntimeException.class, () -> proficiencies.getProficiencies(index));
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
