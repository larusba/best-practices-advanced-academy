package exercises_part2.ex7;

/**
 * REFACTORING COMPLETATO (GREEN)
 * 
 * FEATURE:
 * - Aggiungere supporto per XMLMiner senza copiare-incollare di nuovo tutto il codice comune.
 */
public class Exercise7Step3 {

    public static abstract class DataMiner {
        public final void mine(String path) {
            openFile(path);
            extractData();
            analyzeData();
            closeFile();
        }

        protected void openFile(String path) {
            System.out.println("Opening " + path);
        }

        protected void analyzeData() {
            System.out.println("Analyzing...");
        }

        protected void closeFile() {
            System.out.println("Closing.");
        }

        protected abstract void extractData();
    }

    // Implementazione Concreta 1
    public static class CsvMiner extends DataMiner {
        @Override
        protected void extractData() {
            System.out.println("Extracting CSV...");
        }
    }
}