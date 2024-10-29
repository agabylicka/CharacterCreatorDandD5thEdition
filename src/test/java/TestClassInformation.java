import org.CharacterCreator.DataModel.CharacterClass;
import org.CharacterCreator.HTTP.ClassInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestClassInformation {
    @Test
    public void testClassInformation() {

        //given
        String index = "wizard";
        ClassInformation classInformation = new ClassInformation();
        //when
        CharacterClass actual = classInformation.getClassInformation(index);
        //then
        Assertions.assertNotNull(actual);
    }

    @Test
    public void testReadAllClassesInformation() {
        String index = "";
        ClassInformation classInformation = new ClassInformation();
        CharacterClass actual = classInformation.getClassInformation(index);
        Assertions.assertNull(actual);
    }

    @Test
    public void testNullClassInformation() {
        // given
        String index = null;
        ClassInformation classInformation = new ClassInformation();
        // when
        CharacterClass actual = classInformation.getClassInformation(index);
        // then
        Assertions.assertNull(actual);
    }
    @Test
    public void testNotExistingClass() {
        String index = "Non_existing";
        ClassInformation classInformation = new ClassInformation();
        Assertions.assertThrows(RuntimeException.class, () -> classInformation.getClassInformation(index), "JSON is wrong.");
    }
}
