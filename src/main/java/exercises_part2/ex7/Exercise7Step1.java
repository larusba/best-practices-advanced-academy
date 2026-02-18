package exercises_part2.ex7;

/**
 * STEP 1: CODICE LEGACY
 * 
 * ANALISI CODE SMELL:
 * 1. **Duplicazione Codice (DRY Violation):** `CsvMiner` e `JsonMiner` hanno metodi identici (`openFile`, `closeFile`, `analyze`).
 * 2. **Rischio di Inconsistenza:** Se cambio la logica di `openFile` in una classe, devo ricordarmi di cambiarla anche nell'altra.
 * 
 * FEATURE FUTURA:
 * - Aggiungere supporto per XMLMiner senza copiare-incollare di nuovo tutto il codice comune.
 */
public class Exercise7Step1 {
    public static class CsvMiner {
        public void mine(String path) {
            System.out.println("Opening file " + path); // Comune
            System.out.println("Parsing CSV data...");  // Specifico
            System.out.println("Analyzing data...");    // Comune
            System.out.println("Closing file.");        // Comune
        }
    }

    public static class JsonMiner {
        public void mine(String path) {
            System.out.println("Opening file " + path); // Comune
            System.out.println("Parsing JSON data..."); // Specifico
            System.out.println("Analyzing data...");    // Comune
            System.out.println("Closing file.");        // Comune
        }
    }
}