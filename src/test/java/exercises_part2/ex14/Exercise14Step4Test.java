package exercises_part2.ex14;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise14Step4Test {
    @Test
    void shouldStartParty() {
        Exercise14Step4.Lights lights = mock(Exercise14Step4.Lights.class);
        Exercise14Step4.Stereo stereo = mock(Exercise14Step4.Stereo.class);
        
        Exercise14Step4.HomeFacade facade = new Exercise14Step4.HomeFacade(lights, null, stereo);
        facade.partyMode();

        // FALLISCE (RED)
        verify(lights).strobe();
        verify(stereo).loud();
    }
}