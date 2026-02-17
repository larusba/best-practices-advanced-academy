package exercises_part2.ex11;

/**
 * STEP 3: REFACTORING COMPLETATO (GREEN)
 * Implementazione dell'Adapter che avvolge la LegacyBank.
 */
public class Exercise11Step3 {
    public interface PaymentProcessor { void pay(double amount); }

    public static class LegacyBankAdapter implements PaymentProcessor {
        private LegacyBank bank = new LegacyBank();
        
        @Override
        public void pay(double amount) {
            bank.makePayment(amount); // Adattamento
        }
    }

    static class LegacyBank {
        void makePayment(double v) { System.out.println("Legacy: " + v); }
    }
}