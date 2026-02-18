package exercises_part2.ex13;

/**
 * REFACTORING COMPLETATO (GREEN)
 * 
 * FEATURE:
 * - Aggiungere un FileLogger.
 */
public class Exercise13Step3 {
    public interface Logger {
        void log(String msg);
    }

    public static class NullLogger implements Logger {
        public void log(String m) {
        }
    }

    public static class CustomerService {
        private Logger logger;

        public CustomerService(Logger logger) {
            // Se logger è null, uso il Null Object
            this.logger = (logger != null) ? logger : new NullLogger();
        }

        public void createCustomer(String name) {
            // Niente più if!
            logger.log("Created " + name);
        }
    }
}