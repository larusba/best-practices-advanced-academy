package exercises_part2.ex4;

/**
 * FEATURE:
 * - Aggiungere il supporto per pagamenti in criptovaluta (Bitcoin).
 */
public class Exercise4Step4 {
    public interface PaymentMethod {
        void pay(double amount);
    }

    public static class PaymentProcessor {
        public void process(PaymentMethod method, double amount) {
            method.pay(amount);
        }
    }

    // Nuova classe Stub
    public static class BitcoinPayment implements PaymentMethod {
        public void pay(double amount) {
            // TODO: Implementare logica crypto
        }
    }
}