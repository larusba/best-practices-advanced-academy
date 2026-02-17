package exercises_part2.ex13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Exercise13Step2Test {
    @Test
    void shouldNotThrowExceptionWhenLoggerIsMissing() {
        // Passo null per simulare il caso limite
        Exercise13Step2.CustomerService service = new Exercise13Step2.CustomerService(null);
        
        // FALLISCE (RED): NullPointerException
        assertDoesNotThrow(() -> service.createCustomer("Mario"));
    }
}