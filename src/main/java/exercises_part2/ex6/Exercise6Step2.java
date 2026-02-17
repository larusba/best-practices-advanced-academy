package exercises_part2.ex6;

/**
 * STEP 2: DESIGN DELLA CATENA (RED)
 *
 * OBIETTIVO REFACTORING:
 * Creare una catena di oggetti Handler, dove ognuno decide se gestire il messaggio o passarlo al prossimo.
 */
public class Exercise6Step2 {
    
    public static abstract class LoggerHandler {
        protected LoggerHandler next;
        
        public void setNext(LoggerHandler next) { this.next = next; }
        
        // Metodo template stub
        public void handle(String level, String msg) {
            // TODO: Logica di passaggio
        }
        
        protected abstract void write(String msg);
    }
}