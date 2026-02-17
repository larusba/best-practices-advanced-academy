package exercises_part2.ex6;

public class Exercise6Step4 {
    // Riscrivo la base per contesto
    public static abstract class LoggerHandler {
        protected LoggerHandler next;
        public void setNext(LoggerHandler next) { this.next = next; }
        public void handle(String msg) { /* ... */ }
    }
    
    // Stub del nuovo filtro
    public static class SpamFilter extends LoggerHandler {
        public void handle(String msg) {
            // TODO: Bloccare se contiene "spam"
        }
    }
}