package exercises_part2.ex22;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise22Step3Test {
    @Test
    void shouldConnectUsingInjectedConfig() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // Inietto una configurazione di test senza toccare variabili globali
        Exercise22Step3.ConfigProvider testConfig = () -> "jdbc:h2:mem:test";
        Exercise22Step3.DatabaseService service = new Exercise22Step3.DatabaseService(testConfig);
        
        service.connect();

        // PASSA (GREEN)
        assertTrue(out.toString().contains("jdbc:h2:mem:test"));
    }
}