package exercises_part2.ex22;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Singleton (Global State):** `Configuration.getInstance()` è chiamato ovunque.
 * 2. **Untestable:** Se un test cambia la configurazione, rompe gli altri test (Shared State).
 *
 * FEATURE FUTURA:
 * - Aggiungere supporto per caricare configurazioni da Variabili d'Ambiente (EnvConfig).
 */
public class Exercise22Step1 {
    public static class Configuration {
        private static Configuration instance = new Configuration();
        private String dbUrl = "jdbc:mysql://localhost:3306";

        private Configuration() {}
        public static Configuration getInstance() { return instance; }
        public String getDbUrl() { return dbUrl; }
    }

    public static class DatabaseService {
        public void connect() {
            // Dipendenza nascosta e statica
            String url = Configuration.getInstance().getDbUrl();
            System.out.println("Connecting to " + url);
        }
    }
}