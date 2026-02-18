package exercises_part2.ex6;

/**
 * REFACTORING COMPLETATO (GREEN)
 * 
 * FEATURE:
 * - Aggiungere un filtro "SpamFilter" che blocca certi messaggi prima che vengano loggati.
 */
public class Exercise6Step3 {

    public static abstract class LoggerHandler {
        protected LoggerHandler next;
        protected String supportedLevel;

        public LoggerHandler(String level) {
            this.supportedLevel = level;
        }

        public void setNext(LoggerHandler next) {
            this.next = next;
        }

        public void handle(String level, String msg) {
            if (this.supportedLevel.equals(level)) {
                write(msg);
            }
            // Passa sempre al prossimo (o ferma se gestito, dipende dalla logica)
            if (next != null) {
                next.handle(level, msg);
            }
        }

        protected abstract void write(String msg);
    }

    // Concrete Handler
    public static class InfoHandler extends LoggerHandler {
        public InfoHandler() {
            super("INFO");
        }

        protected void write(String msg) {
            System.out.println("[INFO] " + msg);
        }
    }
}