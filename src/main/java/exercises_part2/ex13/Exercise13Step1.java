package exercises_part2.ex13;

/**
 * STEP 1: CODICE LEGACY
 * 
 * ANALISI CODE SMELL:
 * 1. **Null Checks:** Il codice è pieno di `if (logger != null)`. Questo è error-prone e verboso.
 * 
 * FEATURE FUTURA:
 * - Aggiungere un FileLogger.
 */
public class Exercise13Step1 {
    public interface Logger {
        void log(String msg);
    }

    public static class CustomerService {
        private Logger logger;

        public CustomerService(Logger logger) {
            this.logger = logger;
        }

        public void createCustomer(String name) {
            System.out.println("Customer created");
            if (logger != null) { // Code Smell
                logger.log("Created " + name);
            }
        }
    }
}