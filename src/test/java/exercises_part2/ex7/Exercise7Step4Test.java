package exercises_part2.ex7;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise7Step4Test {
    @Test
    void shouldProcessXml() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exercise7Step4.DataMiner miner = new Exercise7Step4.XmlMiner();
        miner.mine("file.xml");

        // FALLISCE (RED)
        assertTrue(outContent.toString().contains("Extracting XML..."));
    }
}