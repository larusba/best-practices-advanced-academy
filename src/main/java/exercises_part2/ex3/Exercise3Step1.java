package exercises_part2.ex3;

/**
 * STEP 1: CODICE LEGACY
 * 
 * ANALISI CODE SMELL:
 * 1. **Busy Waiting:** Usa un ciclo `while(true)` con `Thread.sleep` per controllare lo stato.
 * 2. **Latenza:** Reagisce agli eventi solo dopo lo sleep, non immediatamente.
 * 
 * FEATURE FUTURA DA IMPLEMENTARE:
 * - Suonare un allarme sonoro quando il file viene rilevato.
 */
public class Exercise3Step1 {
    public static class FileMonitor {
        public void start() {
            while (true) {
                // Polling inefficiente
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }
}