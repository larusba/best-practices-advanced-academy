package exercises_part2.ex14;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise14Step2Test {
    @Test
    void shouldPrepareMovieEnvironment() {
        Exercise14Step2.Lights lights = mock(Exercise14Step2.Lights.class);
        Exercise14Step2.TV tv = mock(Exercise14Step2.TV.class);
        
        Exercise14Step2.HomeFacade facade = new Exercise14Step2.HomeFacade(lights, tv);
        facade.watchMovie();

        // FALLISCE (RED)
        verify(lights).dim();
        verify(tv).on();
    }
}