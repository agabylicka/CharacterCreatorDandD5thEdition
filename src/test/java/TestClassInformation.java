import org.CharacterCreator.HTTP.ClassInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassInformation {
    @Test
    public void testClassInformation() {

        //given
        String index = "wizard";
        ClassInformation classInformation = new ClassInformation();
        //when
        HttpResponse<String> actual = classInformation.getClassInformation(index);
        //then
        Assertions.assertEquals(200, actual.statusCode());
    }

    @Test
    public void testReadAllClassesInformation() {
        String index = "";
        ClassInformation classInformation = new ClassInformation();

        HttpResponse<String> actual = classInformation.getClassInformation(index);
        Assertions.assertEquals(200, actual.statusCode());
    }

    @Test
    public void testNullClassInformation() {
        // given
        String index = null;
        ClassInformation classInformation = new ClassInformation();
        // when
        HttpResponse<String> actual = classInformation.getClassInformation(index);
        // then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(404, actual.statusCode());
    }
    @Test
    public void testNotExistingClass() {
        String index = "Non_existing";
        ClassInformation classInformation = new ClassInformation();
        String expected = "{\"error\":\"Not found\"}";

        HttpResponse<String> actual = classInformation.getClassInformation(index);
        Assertions.assertEquals(404, actual.statusCode());
        Assertions.assertEquals(expected, actual.body());
    }
}
