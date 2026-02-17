package exercises_part2.ex11;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise11Step2Test {
    @Test
    void shouldPayThroughInterface() {
        Exercise11Step2.PaymentProcessor mockProc = mock(Exercise11Step2.PaymentProcessor.class);
        Exercise11Step2.Shop shop = new Exercise11Step2.Shop(mockProc);

        shop.checkout(100.0);

        // FALLISCE (RED): checkout è vuoto
        verify(mockProc).pay(100.0);
    }
}