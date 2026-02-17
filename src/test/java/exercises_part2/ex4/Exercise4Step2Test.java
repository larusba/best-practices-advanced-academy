package exercises_part2.ex4;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise4Step2Test {
    @Test
    void shouldProcessPaymentDelegatingToMethod() {
        Exercise4Step2.PaymentMethod mockMethod = mock(Exercise4Step2.PaymentMethod.class);
        Exercise4Step2.PaymentProcessor processor = new Exercise4Step2.PaymentProcessor();

        processor.process(mockMethod, 100.0);

        // FALLISCE (RED): Il metodo process è vuoto
        verify(mockMethod).pay(100.0);
    }
}