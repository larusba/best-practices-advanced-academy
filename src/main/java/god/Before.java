package god;

public class Before {
    public static class GodObject {
        private String data;
        private DatabaseManager dbManager;
        private Logger logger;
        private Validator validator;

        // Constructor
        public GodObject(String data) {
            this.data = data;
            this.dbManager = new DatabaseManager();
            this.logger = new Logger();
            this.validator = new Validator();
        }

        // Method performing various operations
        public void processData() {
            if (validator.isValid(data)) {
                logger.log("Data is valid");
                dbManager.saveData(data);
                logger.log("Data saved successfully");
            } else {
                logger.log("Invalid data");
            }
        }

        // Other methods related to different responsibilities
        public void performBackup() {
            // Backup logic
            logger.log("Performing backup");
            dbManager.backupData(data);
            logger.log("Backup completed successfully");
        }

        public void performCleanup() {
            // Cleanup logic
            logger.log("Performing cleanup");
            dbManager.cleanupData();
            logger.log("Cleanup completed successfully");
        }
    }

    // Validator.java
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

    // Main.java (for demonstration)
    public static class Main {
        public static void main(String[] args) {
            // Create instance of GodObject
            GodObject godObject = new GodObject("Some data");

            // Process data using GodObject
            godObject.processData();

            // Perform backup
            godObject.performBackup();

            // Perform cleanup
            godObject.performCleanup();
        }
    }
}
