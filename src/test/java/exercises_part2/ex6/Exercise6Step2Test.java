package exercises_part2.ex6;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise6Step2Test {
    @Test
    void shouldPassRequestToNext() {
        // Uso una classe concreta anonima per testare la classe astratta
        Exercise6Step2.LoggerHandler handler1 = spy(new Exercise6Step2.LoggerHandler() {
            protected void write(String msg) {}
        });
        Exercise6Step2.LoggerHandler handler2 = mock(Exercise6Step2.LoggerHandler.class);
        
        handler1.setNext(handler2);
        handler1.handle("ANY", "test");
        
        // FALLISCE (RED): handle() è vuoto e non chiama il next
        verify(handler2).handle("ANY", "test");
    }
}