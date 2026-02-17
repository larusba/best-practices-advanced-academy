package exercises_part2.ex12;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Exercise12Step3Test {
    @Test
    void shouldLoadOnlyOnDisplay() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Exercise12Step3.ImageProxy proxy = new Exercise12Step3.ImageProxy();
        
        // Non deve aver caricato ancora
        assertFalse(out.toString().contains("Loading"));

        proxy.display();

        // Ora deve aver caricato
        assertTrue(out.toString().contains("Loading"));
    }
}