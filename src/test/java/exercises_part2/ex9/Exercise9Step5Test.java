package exercises_part2.ex9;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise9Step5Test {
    @Test
    void shouldCensorBadWords() {
        Exercise9Step5.TextComponent text = mock(Exercise9Step5.TextComponent.class);
        when(text.read()).thenReturn("You are stupid");
        
        Exercise9Step5.Censor censor = new Exercise9Step5.Censor(text);
        
        // PASSA (GREEN)
        assertEquals("You are ***", censor.read());
    }
}