import org.CharacterCreator.DataModel.Character;
import org.CharacterCreator.DataModel.FileWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.UUID;

public class TestFileWriter {
    @Test
    void testWriteFile() {
        // given
        String uuid = UUID.randomUUID().toString();
        String selection = "Alarm";
        String background = "Lorem ipsum";
        org.CharacterCreator.DataModel.Character character = new Character();
        File file = new File("src\\main\\java\\org\\CharacterCreator\\" + uuid + ".txt");
        // when
        FileWriter fileWriter = new FileWriter();
        String actual = fileWriter.writeFile(uuid, character, selection, background);
        // then
        fileWriter.removeFile(uuid);
        Assertions.assertNull(actual);
    }
}
