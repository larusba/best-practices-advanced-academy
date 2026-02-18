package exercises_part2.ex22;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Exercise22Step5Test {
    @Test
    void shouldReadFromEnvironment() {
        Exercise22Step5.EnvConfig config = new Exercise22Step5.EnvConfig();
        // Se la variabile non c'è, torna default, ma non null o crash.
        // PASSA (GREEN)
        assertNotNull(config.getDbUrl());
    }
}