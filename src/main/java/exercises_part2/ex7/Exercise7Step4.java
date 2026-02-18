package exercises_part2.ex7;

/**
 * FEATURE:
 * - Aggiungere supporto per XMLMiner senza copiare-incollare di nuovo tutto il codice comune.
 */
public class Exercise7Step4 {
    public static abstract class DataMiner {
        public final void mine(String path) {
            extractData();
        }

        protected abstract void extractData();
    }

    // Stub della nuova classe XML
    public static class XmlMiner extends DataMiner {
        @Override
        protected void extractData() {
            // TODO: Implementare logica XML
        }
    }
}