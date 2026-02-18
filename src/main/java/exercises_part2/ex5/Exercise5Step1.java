package exercises_part2.ex5;

/**
 * STEP 1: CODICE LEGACY
 * 
 * ANALISI CODE SMELL:
 * 1. **Primitive Obsession:** Lo stato è gestito tramite stringhe ("NEW", "PAID").
 * 2. **Logica Condizionale:** Ogni metodo deve controllare lo stato corrente con if/else.
 * 
 * FEATURE FUTURA:
 * - Aggiungere uno stato "REFUNDED" che permette il rimborso solo se l'ordine è "PAID".
 */
public class Exercise5Step1 {
    public static class Order {
        private String state = "NEW";

        public void pay() {
            if (state.equals("NEW")) {
                state = "PAID";
                System.out.println("Pagato.");
            } else {
                System.out.println("Già pagato o spedito.");
            }
        }

        public void ship() {
            if (state.equals("PAID")) {
                state = "SHIPPED";
                System.out.println("Spedito.");
            } else {
                System.out.println("Non posso spedire.");
            }
        }
    }
}