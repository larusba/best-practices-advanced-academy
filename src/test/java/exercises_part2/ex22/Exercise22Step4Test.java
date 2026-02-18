package exercises_part2.ex22;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise22Step4Test {
    @Test
    void shouldReadFromEnvironment() {
        // Nota: Testare System.getenv è difficile perché è readonly in Java.
        // Di solito si usa un wrapper su System. Qui simuliamo il comportamento fallimentare.
        
        Exercise22Step4.EnvConfig config = new Exercise22Step4.EnvConfig();
        
        // Supponiamo di aver settato DB_URL=production nel sistema (o mocking)
        // FALLISCE (RED): ritorna null
         assertEquals("production", config.getDbUrl()); 
    }
}