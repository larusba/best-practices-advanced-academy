package exercises_part2.ex14;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise14Step5Test {
    @Test
    void shouldStartParty() {
        Exercise14Step5.Lights lights = mock(Exercise14Step5.Lights.class);
        Exercise14Step5.Stereo stereo = mock(Exercise14Step5.Stereo.class);
        
        Exercise14Step5.HomeFacade facade = new Exercise14Step5.HomeFacade(lights, stereo);
        facade.partyMode();

        // PASSA (GREEN)
        verify(lights).strobe();
        verify(stereo).loud();
    }
}