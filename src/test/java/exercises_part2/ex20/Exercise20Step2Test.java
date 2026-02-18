package exercises_part2.ex20;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise20Step2Test {
    @Test
    void shouldControlDevice() {
        Exercise20Step2.Device mockDevice = mock(Exercise20Step2.Device.class);
        Exercise20Step2.Remote remote = new Exercise20Step2.Remote(mockDevice);
        
        remote.togglePower();

        // FALLISCE (RED): togglePower vuoto
        verify(mockDevice).enable(); // Assumendo logica iniziale
    }
}