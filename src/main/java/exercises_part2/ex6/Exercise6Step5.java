package exercises_part2.ex6;

public class Exercise6Step5 {

    public static abstract class LoggerHandler {
        protected LoggerHandler next;

        public void setNext(LoggerHandler next) {
            this.next = next;
        }

        public void handle(String msg) {
            if (next != null) next.handle(msg);
        }
    }

    // Implementazione Reale del Filtro
    public static class SpamFilter extends LoggerHandler {
        @Override
        public void handle(String msg) {
            if (msg.contains("spam")) {
                System.out.println("Bloccato messaggio spam.");
                return; // INTERROMPE LA CATENA
            }
            if (next != null) next.handle(msg);
        }
    }
}