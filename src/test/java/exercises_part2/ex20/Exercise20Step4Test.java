package exercises_part2.ex20;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise20Step4Test {
    @Test
    void shouldMuteDevice() {
        Exercise20Step3.Device device = mock(Exercise20Step3.Device.class);
        Exercise20Step4.AdvancedRemote remote = new Exercise20Step4.AdvancedRemote(device);
        
        remote.mute();
        
        // FALLISCE (RED): Mute vuoto
        verify(device).disable(); // Assumiamo mute = setVolume(0) o disable audio
    }
}