package exercises_part2.ex4;

public class Exercise4Step5 {
    public interface PaymentMethod { void pay(double amount); }
    
    public static class PaymentProcessor {
        public void process(PaymentMethod method, double amount) { method.pay(amount); }
    }

    // Implementazione Reale
    public static class BitcoinPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Pagamento Crypto: " + amount);
        }
    }
}