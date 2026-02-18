package exercises_part2.ex11;

/**
 * FEATURE:
 * - Aggiungere il supporto per una nuova API di pagamento "Stripe-like" senza cambiare il codice del Client.
 */
public class Exercise11Step4 {
    public interface PaymentProcessor {
        void pay(double amount);
    }

    // Stub della nuova implementazione
    public static class ModernPaymentAdapter implements PaymentProcessor {
        public void pay(double amount) {
            // TODO: Chiamare la nuova API
        }
    }
}