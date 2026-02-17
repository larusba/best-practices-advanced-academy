package exercises_part2.ex7;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise7Step3Test {
    @Test
    void shouldExecuteSpecificStep() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exercise7Step3.DataMiner miner = new Exercise7Step3.CsvMiner();
        miner.mine("file.csv");

        // PASSA (GREEN)
        String output = outContent.toString();
        assertTrue(output.contains("Opening file.csv")); // Base
        assertTrue(output.contains("Extracting CSV...")); // Specifico
        assertTrue(output.contains("Closing.")); // Base
    }
}