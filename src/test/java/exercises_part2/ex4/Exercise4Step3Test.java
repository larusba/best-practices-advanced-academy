package exercises_part2.ex4;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise4Step3Test {
    @Test
    void shouldProcessPayment() {
        Exercise4Step3.PaymentMethod mockMethod = mock(Exercise4Step3.PaymentMethod.class);
        Exercise4Step3.PaymentProcessor processor = new Exercise4Step3.PaymentProcessor();

        processor.process(mockMethod, 100.0);

        // PASSA (GREEN)
        verify(mockMethod).pay(100.0);
    }
}