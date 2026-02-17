package exercises_part2.ex14;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise14Step3Test {
    @Test
    void shouldPrepareMovieEnvironment() {
        Exercise14Step3.Lights lights = mock(Exercise14Step3.Lights.class);
        Exercise14Step3.TV tv = mock(Exercise14Step3.TV.class);
        
        Exercise14Step3.HomeFacade facade = new Exercise14Step3.HomeFacade(lights, tv);
        facade.watchMovie();

        // PASSA (GREEN)
        verify(lights).dim();
        verify(tv).on();
    }
}