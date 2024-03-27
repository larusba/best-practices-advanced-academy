package god;

/**
 * In the refactored version, each class (Validator, Logger, DatabaseManager, and Processor) has a
 * clear responsibility, making the code easier to understand and maintain. The Processor class
 * handles the orchestration of various operations and is responsible for coordinating between the
 * other classes.
 *
 * <p>It doesn't initialize object inside the class, but outside and inject it
 *
 * <p>For small classes it might be worth remain the God Object, it depends on the complexity
 */
public class After { // Validator.java
    public static class Validator {
        public boolean isValid(String data) {
            // Validation logic
            return true;
        }
    }

    // Logger.java
    public static class Logger {
        public void log(String message) {
            // Logging logic
            System.out.println(message);
        }
    }

    // DatabaseManager.java
    public static class DatabaseManager {
        public void saveData(String data) {
            // Database saving logic
        }

        public void backupData(String data) {
            // Backup logic
        }

        public void cleanupData() {
            // Cleanup logic
        }
    }

    // Processor.java
    public static class Processor {
        private Validator validator;
        private Logger logger;
        private DatabaseManager dbManager;

        public Processor(Validator validator, Logger logger, DatabaseManager dbManager) {
            this.validator = validator;
            this.logger = logger;
            this.dbManager = dbManager;
        }

        public void processData(String data) {
            if (validator.isValid(data)) {
                logger.log("Data is valid");
                dbManager.saveData(data);
                logger.log("Data saved successfully");
            } else {
                logger.log("Invalid data");
            }
        }
    }

    // DataHandler.java
    public static class DataHandler {

        private Logger logger;
        private DatabaseManager dbManager;

        public DataHandler(Logger logger, DatabaseManager dbManager) {
            this.logger = logger;
            this.dbManager = dbManager;
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

    // Main.java (for demonstration)
    public static class Main {
        public static void main(String[] args) {
            // Create instances of dependencies
            Validator validator = new Validator();
            Logger logger = new Logger();
            DatabaseManager dbManager = new DatabaseManager();

            // Create instance of Processor
            Processor processor = new Processor(validator, logger, dbManager);

            // Process some data
            String data1 = "Some valid data";
            processor.processData(data1);

            DataHandler dataHandler = new DataHandler(logger, dbManager);
            // Perform backup
            String backupData = "Backup data";
            dataHandler.performBackup(backupData);

            // Perform cleanup
            dataHandler.performCleanup();
        }
    }
}
