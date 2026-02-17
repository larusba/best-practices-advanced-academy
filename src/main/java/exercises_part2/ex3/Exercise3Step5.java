package exercises_part2.ex3;

import java.util.ArrayList;
import java.util.List;

public class Exercise3Step5 {
    public interface FileListener { void onFile(); }
    public interface Alarm { void ring(); }

    public static class FileMonitor {
        private List<FileListener> listeners = new ArrayList<>();
        public void addListener(FileListener l) { listeners.add(l); }
        public void fileDetected() { listeners.forEach(FileListener::onFile); }
    }

    // NUOVA IMPLEMENTAZIONE: Adattatore per l'allarme
    public static class AlarmListener implements FileListener {
        private Alarm alarm;
        public AlarmListener(Alarm alarm) { this.alarm = alarm; }
        
        @Override
        public void onFile() {
            alarm.ring();
        }
    }
}