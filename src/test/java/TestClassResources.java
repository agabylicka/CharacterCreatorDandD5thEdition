import org.example.ClassResources;
import org.example.Proficiencies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassResources {
    @Test
    public void testClassResources() {
        String index = "monk";
        ClassResources classResources = new ClassResources();
        //String expected = "monk";
        HttpResponse<String> actual = classResources.getClassResources(index);
        //Assertions.assertTrue(actual.body().contains(expected));
        Assertions.assertEquals(200, actual.statusCode());
    }
}

