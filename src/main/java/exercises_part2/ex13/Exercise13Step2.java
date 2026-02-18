package exercises_part2.ex13;

/**
 * STEP 2: DESIGN NULL OBJECT (RED)
 * 
 * OBIETTIVO:
 * Creare un oggetto `NullLogger` che non fa nulla, da usare al posto di `null`.
 * Rimuovere i check nel service.
 */
public class Exercise13Step2 {
    public interface Logger {
        void log(String msg);
    }

    public static class NullLogger implements Logger {
        public void log(String msg) { /* Do nothing */ }
    }

    public static class CustomerService {
        private Logger logger;

        // Stub: Non gestisce ancora il default
        public CustomerService(Logger logger) {
            this.logger = logger;
        }

        public void createCustomer(String name) {
            // TODO: Rimuovere if null
            logger.log(name); // Qui esploderà se passo null
        }
    }
}