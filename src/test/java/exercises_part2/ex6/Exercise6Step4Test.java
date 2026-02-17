package exercises_part2.ex6;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise6Step4Test {
    @Test
    void shouldBlockSpam() {
        Exercise6Step4.SpamFilter filter = new Exercise6Step4.SpamFilter();
        Exercise6Step4.LoggerHandler next = mock(Exercise6Step4.LoggerHandler.class);
        
        filter.setNext(next);
        filter.handle("Questo è spam pubblicitario");
        
        // FALLISCE (RED): Attualmente passa tutto al next
        verify(next, never()).handle(anyString());
    }
}