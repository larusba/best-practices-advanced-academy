package exercises_part2.ex13;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Exercise13Step3Test {
    @Test
    void shouldNotThrowExceptionWhenLoggerIsMissing() {
        Exercise13Step3.CustomerService service = new Exercise13Step3.CustomerService(null);
        
        // PASSA (GREEN): Usa NullLogger internamente
        assertDoesNotThrow(() -> service.createCustomer("Mario"));
    }
}