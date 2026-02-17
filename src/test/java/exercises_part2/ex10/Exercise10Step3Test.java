package exercises_part2.ex10;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise10Step3Test {
    @Test
    void shouldDeliverUsingSpecificTransport() {
        // Testo la logica core usando un mock
        Exercise10Step3.Transport mockTransport = mock(Exercise10Step3.Transport.class);
        
        Exercise10Step3.Logistics logistics = new Exercise10Step3.Logistics() {
            public Exercise10Step3.Transport createTransport() { return mockTransport; }
        };

        logistics.planDelivery();

        // PASSA (GREEN)
        verify(mockTransport).deliver();
    }
}