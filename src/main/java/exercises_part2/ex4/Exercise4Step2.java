package exercises_part2.ex4;

/**
 * STEP 2: DESIGN DELL'ASTRAZIONE (RED)
 *
 * OBIETTIVO REFACTORING:
 * Estrarre la logica di pagamento in classi dedicate intercambiabili.
 *
 * PIANO D'AZIONE:
 * 1. Creare un'interfaccia comune per i pagamenti.
 * 2. Modificare il processore per accettare l'interfaccia invece di una stringa.
 */
public class Exercise4Step2 {
    
    // 1. Interfaccia comune
    public interface PaymentMethod {
        void pay(double amount);
    }

    public static class PaymentProcessor {
        // Stub: Accetta la strategia ma non fa nulla
        public void process(PaymentMethod method, double amount) {
            // TODO: Delegare al metodo
        }
    }
}