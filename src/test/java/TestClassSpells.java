import org.example.ClassSpells;
import org.example.Proficiencies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestClassSpells {
        @Test
        public void testClassSpells() {
            String index = "bard";
            ClassSpells classSpells = new ClassSpells();
            String expected = "Bane";
            HttpResponse<String> actual = classSpells.getClassSpells(index);
            Assertions.assertTrue(actual.body().contains(expected));
        }
}
