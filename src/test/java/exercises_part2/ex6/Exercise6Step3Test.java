package exercises_part2.ex6;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise6Step3Test {
    @Test
    void shouldHandleAndPass() {
        Exercise6Step3.InfoHandler info = new Exercise6Step3.InfoHandler();
        Exercise6Step3.LoggerHandler next = mock(Exercise6Step3.LoggerHandler.class);
        
        info.setNext(next);
        info.handle("INFO", "Messaggio");
        
        // PASSA: Ha gestito (stampa su console) e passato avanti
        verify(next).handle("INFO", "Messaggio");
    }
}