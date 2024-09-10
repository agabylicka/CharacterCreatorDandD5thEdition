import org.example.HTTP.ClassResources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassResources {
    @Test
    public void testClassResources() {
        String index = "monk";
        ClassResources classResources = new ClassResources();
        HttpResponse<String> actual = classResources.getClassResources(index);
        Assertions.assertEquals(200, actual.statusCode());
    }

    @Test
    public void testNullClassResources() {
        String index = null;
        ClassResources classResources = new ClassResources();
        Assertions.assertThrows(RuntimeException.class, () -> classResources.getClassResources(index));
    }

    @Test
    public void testUnhappyClassResources() {
        String index = "";
        ClassResources classResources = new ClassResources();

        HttpResponse<String> actual = classResources.getClassResources(index);
        Assertions.assertEquals(404, actual.statusCode());
    }

    @Test
    public void testNotExistingClassEqualsZeroResult() {
        String index = "Non_existing";
        ClassResources classResources = new ClassResources();
        String expected = "{\"error\":\"Not found\"}";

        HttpResponse<String> actual = classResources.getClassResources(index);
        Assertions.assertEquals(404, actual.statusCode());
        Assertions.assertEquals(expected, actual.body());
    }
}

