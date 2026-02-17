package exercises_part2.ex11;

/**
 * STEP 2: DESIGN DELL'ADAPTER (RED)
 *
 * OBIETTIVO:
 * Creare un'interfaccia standard `PaymentProcessor` che il Client userà.
 * Creare un adattatore per la LegacyBank.
 */
public class Exercise11Step2 {
    
    // 1. Target Interface
    public interface PaymentProcessor {
        void pay(double amount);
    }

    // 2. Client rifattorizzato per usare l'interfaccia
    public static class Shop {
        private PaymentProcessor processor;

        public Shop(PaymentProcessor processor) {
            this.processor = processor;
        }

        public void checkout(double amount) {
            // TODO: Delegare al processore
        }
    }
}