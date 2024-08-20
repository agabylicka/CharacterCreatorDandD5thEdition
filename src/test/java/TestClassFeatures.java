import org.example.ClassFeatures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassFeatures {
    @Test
    public void testClassFeatures() {
        String index = "druid";
        ClassFeatures classFeatures = new ClassFeatures();

        HttpResponse<String> actual = classFeatures.getClassFeatures(index);
        Assertions.assertEquals(200, actual.statusCode());
    }
    @Test
    public void testNullClassFeatures() {
        String index = null;
        ClassFeatures classFeatures = new ClassFeatures();
        Assertions.assertThrows(RuntimeException.class, () -> classFeatures.getClassFeatures(index));
    }

    @Test
    public void testUnhappyClassFeatures() {
        String index = "";
        ClassFeatures classFeatures = new ClassFeatures();

        HttpResponse<String> actual = classFeatures.getClassFeatures(index);
        Assertions.assertEquals(404, actual.statusCode());
    }
    @Test
    public void testNotExistingClassEqualsZeroResult() {
        String index = "Non_existing";
        ClassFeatures classFeatures = new ClassFeatures();
        String expected = "{\"count\":0,\"results\":[]}";

        HttpResponse<String> actual = classFeatures.getClassFeatures(index);
        Assertions.assertEquals(200, actual.statusCode());
        Assertions.assertEquals(expected, actual.body());
    }
}
