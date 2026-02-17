package exercises_part2.ex3;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise3Step4Test {
    @Test
    void alarmShouldSound() {
        Exercise3Step4.FileMonitor monitor = new Exercise3Step4.FileMonitor();
        Exercise3Step4.Alarm mockAlarm = mock(Exercise3Step4.Alarm.class);
        
        // Nel test (RED), proviamo a simulare l'integrazione con un adattatore
        // che ancora non esiste come classe concreta.
        Exercise3Step4.FileListener alarmAdapter = () -> mockAlarm.ring();
        
        monitor.addListener(alarmAdapter);
        monitor.fileDetected();
        
        verify(mockAlarm).ring();
    }
}