package exercises_part2.ex20;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise20Step3Test {
    @Test
    void shouldTogglePower() {
        Exercise20Step3.TV tv = new Exercise20Step3.TV();
        Exercise20Step3.Remote remote = new Exercise20Step3.Remote(tv);
        
        remote.togglePower();
        
        // PASSA (GREEN)
        assertTrue(tv.isEnabled());
    }
}