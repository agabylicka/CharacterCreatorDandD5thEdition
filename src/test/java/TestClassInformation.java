import org.example.ClassInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassInformation {
    @Test
    public void testClassInformation() {

        //given
        String index = "wizard";
        ClassInformation classInformation = new ClassInformation();
        //String expected = "wizard";
        //when
        HttpResponse<String> actual = classInformation.getClassInformation(index);

        //then
        //Assertions.assertTrue(actual.body().contains(expected));
        Assertions.assertEquals(200, actual.statusCode());
    }
}
