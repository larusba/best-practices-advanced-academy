package exercises_part2.ex3;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise3Step4Test {
    @Test
    void alarmShouldSound() {
        Exercise3Step4.FileMonitor monitor = new Exercise3Step4.FileMonitor();
        Exercise3Step4.Alarm mockAlarm = mock(Exercise3Step4.Alarm.class);

        // Uso la classe reale AlarmListener (che è vuota)
        Exercise3Step4.AlarmListener myListener = new Exercise3Step4.AlarmListener(mockAlarm);

        monitor.addListener(myListener);
        monitor.fileDetected();

        // FALLISCE (RED): AlarmListener.onFile() è vuoto, quindi alarm.ring() non viene chiamato
        verify(mockAlarm).ring();
    }
}