package exercises_part2.ex12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise12Step4Test {
    @Test
    void shouldThrowExceptionIfUserNotAdmin() {
        Exercise12Step4.SecureProxy proxy = new Exercise12Step4.SecureProxy("GUEST");
        
        // FALLISCE (RED): Non lancia eccezione
        assertThrows(SecurityException.class, proxy::display);
    }
}