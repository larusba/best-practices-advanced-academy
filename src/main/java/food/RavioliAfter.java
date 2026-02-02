package food;

/**
 * SOLUZIONE: Dependency Injection (Iniezione delle Dipendenze).
 *
 * Abbiamo applicato il pattern dell'Inversione del Controllo (IoC).
 * DataProcessor non crea più le sue dipendenze, ma le *richiede* al costruttore.
 *
 * VANTAGGI:
 * - Testabilità: Possiamo passare un "MockLogger" o "MockDatabase" nei test
 * per verificare la logica di DataProcessor senza effetti collaterali.
 * - Flessibilità: Possiamo cambiare l'implementazione del DatabaseManager nel Main
 * senza toccare una riga di codice di DataProcessor.
 * - Separation of Concerns: DataProcessor si occupa di logica, Main si occupa di "assemblaggio".
 */
public class RavioliAfter {

    // DataProcessor.java
    public static class DataProcessor {
        private Validator validator;
        private Logger logger;
        private DatabaseManager dbManager;

        /**
         * BEST PRACTICE: Constructor Injection.
         *
         * Le dipendenze sono dichiarate esplicitamente come parametri.
         * Questo rende chiaro di cosa ha bisogno la classe per funzionare.
         */
        public DataProcessor(Validator validator, Logger logger, DatabaseManager dbManager) {
            this.validator = validator;
            this.logger = logger;
            this.dbManager = dbManager;
        }

        public void processData(String data) {
            if (validator.validateData(data)) {
                logger.log("Data is valid");
                dbManager.saveData(data);
                logger.log("Data saved successfully");
            } else {
                logger.logError("Invalid data");
            }
        }

        public void processUser(String username, String password) {
            if (validator.validateUser(username, password)) {
                logger.log("User data is valid");
                dbManager.saveUser(username, password);
                logger.log("User saved successfully");
            } else {
                logger.logError("Invalid user data");
            }
        }

        public void performBackup(String data) {
            logger.log("Performing backup");
            dbManager.backupData(data);
            logger.log("Backup completed successfully");
        }

        public void performCleanup() {
            logger.log("Performing cleanup");
            dbManager.cleanupData();
            logger.log("Cleanup completed successfully");
        }
    }

    // Validator.java
    public static class Validator {
        public boolean validateData(String data) {
            // Validation logic
            return data != null && !data.isEmpty();
        }

        public boolean validateUser(String username, String password) {
            // Validation logic
            return username != null
                    && !username.isEmpty()
                    && password != null
                    && !password.isEmpty();
        }
    }

    // Logger.java
    public static class Logger {
        public void log(String message) {
            // Logging logic
            System.out.println(message);
        }

        public void logError(String errorMessage) {
            // Error logging logic
            System.err.println("ERROR: " + errorMessage);
        }
    }

    // DatabaseManager.java
    public static class DatabaseManager {
        public void saveData(String data) {
            // Database saving logic
            System.out.println("Saving data: " + data);
        }

        public void backupData(String data) {
            // Backup logic
            System.out.println("Backing up data: " + data);
        }

        public void cleanupData() {
            // Cleanup logic
            System.out.println("Cleaning up data");
        }

        public void saveUser(String username, String password) {
            // Save user logic
            System.out.println("Saving user: " + username);
        }
    }

    // Main.java (for demonstration)
    public static class Main {
        public static void main(String[] args) {
            // Wiring (Cablaggio):
            // Creiamo le istanze delle dipendenze.
            Validator validator = new Validator();
            Logger logger = new Logger();
            DatabaseManager dbManager = new DatabaseManager();

            // Iniettiamo le dipendenze nel processore.
            // Questo è il concetto di "Ravioli" fatto bene: piccoli oggetti coesi
            // che vengono assemblati insieme dall'esterno.
            DataProcessor processor = new DataProcessor(validator, logger, dbManager);
            
            String data = "Some data";
            String username = "user";
            String password = "password";

            // Process data
            processor.processData(data);

            // Process user
            processor.processUser(username, password);

            // Perform backup
            processor.performBackup(data);

            // Perform cleanup
            processor.performCleanup();
        }
    }
}