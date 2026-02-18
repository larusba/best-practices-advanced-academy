package exercises_part2.ex20;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise20Step5Test {
    @Test
    void shouldMuteDevice() {
        Exercise20Step5.Device device = mock(Exercise20Step5.Device.class);
        Exercise20Step5.AdvancedRemote remote = new Exercise20Step5.AdvancedRemote(device);
        
        remote.mute();
        
        // PASSA (GREEN)
        verify(device).setVolume(0);
    }
}