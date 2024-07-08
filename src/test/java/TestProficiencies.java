import org.example.Proficiencies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestProficiencies {
    @Test
    public void testProficiencies() {
        String index = "elf";
        Proficiencies proficiencies = new Proficiencies();
        //String expected = "Perception";
        HttpResponse<String> actual = proficiencies.getProficiencies(index);
        //Assertions.assertTrue(actual.body().contains(expected));
        Assertions.assertEquals(200, actual.statusCode());
    }
}
