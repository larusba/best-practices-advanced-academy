package exercises_part2.ex7;

/**
 * STEP 2: DESIGN DELL'ASTRAZIONE (RED)
 * 
 * OBIETTIVO REFACTORING:
 * Creare una classe base che contenga lo scheletro dell'algoritmo.
 * I passaggi specifici saranno delegati alle sottoclassi.
 */
public class Exercise7Step2 {

    public static abstract class DataMiner {
        // Il "Template Method" definisce la sequenza
        public final void mine(String path) {
            openFile(path);
            extractData(); // Passaggio astratto
            analyzeData();
            closeFile();
        }

        protected void openFile(String path) { /* TODO: Implementare */ }

        protected void analyzeData() { /* TODO: Implementare */ }

        protected void closeFile() { /* TODO: Implementare */ }

        // Hook/Abstract method da implementare
        protected abstract void extractData();
    }
}