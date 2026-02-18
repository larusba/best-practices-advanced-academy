package exercises_part2.ex11;

/**
 * REFACTORING COMPLETATO (GREEN)
 * Implementazione dell'Adapter che avvolge la LegacyBank.
 * 
 * FEATURE:
 * - Aggiungere il supporto per una nuova API di pagamento "Stripe-like" senza cambiare il codice del Client.
 */
public class Exercise11Step3 {
    public interface PaymentProcessor {
        void pay(double amount);
    }

    public static class LegacyBankAdapter implements PaymentProcessor {
        private LegacyBank bank = new LegacyBank();

        @Override
        public void pay(double amount) {
            bank.makePayment(amount); // Adattamento
        }
    }

    static class LegacyBank {
        void makePayment(double v) {
            System.out.println("Legacy: " + v);
        }
    }
}