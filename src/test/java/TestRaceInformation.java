import org.example.ClassFeatures;
import org.example.RaceInformation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.http.HttpResponse;

public class TestRaceInformation {
    @Test
    public void testRaceInformation() {
        String index = "gnome";
        RaceInformation raceInformation = new RaceInformation();
        String expected = "gnome";

        HttpResponse<String> actual = raceInformation.getRaceInformation(index);
        Assertions.assertTrue(actual.body().contains(expected));

    }
}
