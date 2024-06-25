import org.example.ClassFeatures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassFeatures {
    @Test
    public void testClassFeatures() {
        String index = "druid";
        ClassFeatures classFeatures = new ClassFeatures();
        String expected = "druid";

        HttpResponse<String> actual = classFeatures.getClassFeatures(index);
        Assertions.assertTrue(actual.body().contains(expected));

    }
}
