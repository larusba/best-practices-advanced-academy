package exercises_part2.ex6;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise6Step5Test {
    @Test
    void shouldBlockSpam() {
        Exercise6Step5.SpamFilter filter = new Exercise6Step5.SpamFilter();
        Exercise6Step5.LoggerHandler next = mock(Exercise6Step5.LoggerHandler.class);
        
        filter.setNext(next);
        filter.handle("Questo è spam");
        
        // PASSA (GREEN): next non viene mai chiamato
        verify(next, never()).handle(anyString());
    }
}