package exercises_part2.ex3;

import java.util.ArrayList;
import java.util.List;

/**
 * FEATURE:
 * - Suonare un allarme sonoro quando il file viene rilevato.
 * 
 * STEP 4: IMPLEMENTAZIONE FEATURE PARZIALE (RED)
 * * Creiamo la classe `AlarmListener` che dovrebbe suonare l'allarme,
 * MA lasciamo il metodo `onFile()` vuoto per dimostrare che la feature non è ancora attiva.
 */
public class Exercise3Step4 {
    public interface FileListener {
        void onFile();
    }

    public interface Alarm {
        void ring();
    }

    // Monitor funzionante (dallo Step 3)
    public static class FileMonitor {
        private List<FileListener> listeners = new ArrayList<>();

        public void addListener(FileListener l) {
            listeners.add(l);
        }

        public void fileDetected() {
            listeners.forEach(FileListener::onFile);
        }
    }

    // NUOVO COMPONENTE (Incompleto)
    public static class AlarmListener implements FileListener {
        private Alarm alarm;

        public AlarmListener(Alarm alarm) {
            this.alarm = alarm;
        }

        @Override
        public void onFile() {
            // TODO: Implementare la chiamata alarm.ring()
            // Lasciato vuoto intenzionalmente per far fallire il test
        }
    }
}