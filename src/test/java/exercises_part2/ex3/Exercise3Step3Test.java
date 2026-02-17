package exercises_part2.ex3;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise3Step3Test {
    @Test
    void shouldNotifyImmediate() {
        Exercise3Step3.FileMonitor monitor = new Exercise3Step3.FileMonitor();
        Exercise3Step3.FileListener listener = mock(Exercise3Step3.FileListener.class);
        
        monitor.addListener(listener); 
        monitor.fileDetected(); 
        
        // PASSA (GREEN)
        verify(listener).onFile();     
    }
}