package exercises_part2.ex7;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise7Step5Test {
    @Test
    void shouldProcessXml() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exercise7Step5.DataMiner miner = new Exercise7Step5.XmlMiner();
        miner.mine("file.xml");

        // PASSA (GREEN)
        assertTrue(outContent.toString().contains("Extracting XML..."));
    }
}