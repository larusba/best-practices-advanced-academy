package exercises_part2.ex22;

public class Exercise22Step3 {
    public interface ConfigProvider { String getDbUrl(); }

    // Implementazione Default (simula il vecchio Singleton ma istanziabile)
    public static class DefaultConfig implements ConfigProvider {
        public String getDbUrl() { return "jdbc:mysql://localhost:3306"; }
    }

    public static class DatabaseService {
        private ConfigProvider config;

        public DatabaseService(ConfigProvider config) {
            this.config = config;
        }

        public void connect() {
            System.out.println("Connecting to " + config.getDbUrl());
        }
    }
}