package exercises_part2.ex22;

/**
 * STEP 2: DESIGN DI (RED)
 *
 * OBIETTIVO:
 * Creare interfaccia `ConfigProvider`.
 * Iniettare la configurazione nel Service.
 */
public class Exercise22Step2 {
    
    public interface ConfigProvider {
        String getDbUrl();
    }

    public static class DatabaseService {
        private ConfigProvider config;

        // Costruttore per Injection
        public DatabaseService(ConfigProvider config) {
            this.config = config;
        }

        public void connect() {
            // TODO: Usare config.getDbUrl()
        }
    }
}