import org.CharacterCreator.DataModel.Character;
import org.CharacterCreator.DataModel.FileToWrite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.UUID;

public class TestFileToWrite {
    @Test
    void testWriteFile() {
        // given
        String uuid = UUID.randomUUID().toString();
        String selection = "Alarm";
        String background = "Lorem ipsum";
        Character character = new Character();
        File file = new File("src\\main\\java\\org\\CharacterCreator\\" + uuid + ".txt");
        // when
        FileToWrite fileToWrite = new FileToWrite();
        String actual = fileToWrite.writeFile(uuid, character, selection, background);
        // then
        fileToWrite.removeFile(uuid);
        Assertions.assertNull(actual);
    }
}
