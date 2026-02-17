package exercises_part2.ex9;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise9Step4Test {
    @Test
    void shouldCensorBadWords() {
        Exercise9Step4.TextComponent text = mock(Exercise9Step4.TextComponent.class);
        when(text.read()).thenReturn("You are stupid");
        
        Exercise9Step4.Censor censor = new Exercise9Step4.Censor(text);
        
        // FALLISCE (RED): Non sostituisce ancora nulla
        assertEquals("You are ***", censor.read());
    }
}