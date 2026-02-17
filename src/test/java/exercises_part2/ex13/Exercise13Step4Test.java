package exercises_part2.ex13;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise13Step4Test {
    @Test
    void shouldLogToFile() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out)); // Simulo file system con console

        Exercise13Step4.FileLogger fl = new Exercise13Step4.FileLogger();
        fl.log("Test");

        // FALLISCE (RED)
        assertTrue(out.toString().contains("Writing to file: Test"));
    }
}