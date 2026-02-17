package exercises_part2.ex3;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise3Step5Test {
    @Test
    void alarmShouldSound() {
        Exercise3Step5.FileMonitor monitor = new Exercise3Step5.FileMonitor();
        Exercise3Step5.Alarm mockAlarm = mock(Exercise3Step5.Alarm.class);
        
        // Uso la classe concreta
        monitor.addListener(new Exercise3Step5.AlarmListener(mockAlarm));
        monitor.fileDetected();
        
        // PASSA (GREEN)
        verify(mockAlarm).ring();
    }
}