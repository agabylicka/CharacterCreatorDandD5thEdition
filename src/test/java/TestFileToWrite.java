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
        String name = "Sara";
        String selection = "Alarm";
        String background = "Lorem ipsum";
        String className = "wizard";
        String race = "elf";
        //Character character = new Character();
        File file = new File("src\\main\\java\\org\\CharacterCreator\\" + name + ".txt");
        // when
        FileToWrite fileToWrite = new FileToWrite();
        //                          writeFile(name, selection, background, className, race) {
        String actual = fileToWrite.writeFile(name, selection, background, className, race);
        // then
        fileToWrite.removeFile(name);
        Assertions.assertNotNull(actual);
    }
}
