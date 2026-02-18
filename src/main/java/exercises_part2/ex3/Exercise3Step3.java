package exercises_part2.ex3;

import java.util.ArrayList;
import java.util.List;

/**
 * REFACTORING COMPLETATO (GREEN)
 * Il Monitor ora mantiene una lista di Listener e li notifica quando accade l'evento.
 * 
 * FEATURE:
 * - Suonare un allarme sonoro quando il file viene rilevato.
 */
public class Exercise3Step3 {
    public interface FileListener {
        void onFile();
    }

    public static class FileMonitor {
        private List<FileListener> listeners = new ArrayList<>();

        public void addListener(FileListener l) {
            listeners.add(l);
        }

        public void fileDetected() {
            for (FileListener l : listeners) {
                l.onFile();
            }
        }
    }
}