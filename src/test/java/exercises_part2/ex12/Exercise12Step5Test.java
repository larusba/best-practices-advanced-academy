package exercises_part2.ex12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise12Step5Test {
    @Test
    void shouldThrowExceptionIfUserNotAdmin() {
        Exercise12Step5.SecureProxy proxy = new Exercise12Step5.SecureProxy("GUEST");
        
        // PASSA (GREEN)
        assertThrows(SecurityException.class, proxy::display);
    }
}