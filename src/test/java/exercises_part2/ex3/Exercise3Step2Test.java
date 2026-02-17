package exercises_part2.ex3;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise3Step2Test {
    @Test
    void shouldNotifyImmediate() {
        Exercise3Step2.FileMonitor monitor = new Exercise3Step2.FileMonitor();
        Exercise3Step2.FileListener listener = mock(Exercise3Step2.FileListener.class);
        
        monitor.addListener(listener); 
        monitor.fileDetected(); 
        
        // FALLISCE (RED): fileDetected() è vuoto, quindi non chiama onFile()
        verify(listener).onFile();     
    }
}