package exercises_part2.ex3;

/**
 * STEP 2: DESIGN DELL'OBSERVER (RED)
 *
 * OBIETTIVO REFACTORING:
 * Applicare il **OBSERVER PATTERN**.
 *
 * 1. Definire interfaccia `FileListener` (Observer).
 * 2. Il `FileMonitor` (Subject) deve accettare sottoscrizioni.
 * 3. Il `FileMonitor` notifica gli iscritti invece di aspettare in un loop.
 */
public class Exercise3Step2 {
    public interface FileListener { void onFile(); }

    public static class FileMonitor {
        // Stub: Metodo per aggiungere listener (vuoto)
        public void addListener(FileListener l) { }
        
        // Stub: Metodo che scatta all'evento (vuoto)
        public void fileDetected() { }
    }
}