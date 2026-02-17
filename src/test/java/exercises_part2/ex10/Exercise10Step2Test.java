package exercises_part2.ex10;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise10Step2Test {
    @Test
    void shouldCreateAndDeliver() {
        Exercise10Step2.Transport mockTransport = mock(Exercise10Step2.Transport.class);
        
        // Creiamo una sottoclasse concreta anonima per il test
        Exercise10Step2.Logistics logistics = new Exercise10Step2.Logistics() {
            @Override
            public Exercise10Step2.Transport createTransport() {
                return mockTransport;
            }
        };

        logistics.planDelivery();

        // FALLISCE (RED): planDelivery() non chiama ancora deliver()
        verify(mockTransport).deliver();
    }
}