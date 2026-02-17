package exercises_part2.ex11;

public class Exercise11Step4 {
    public interface PaymentProcessor { void pay(double amount); }
    
    // Stub della nuova implementazione
    public static class ModernPaymentAdapter implements PaymentProcessor {
        public void pay(double amount) {
            // TODO: Chiamare la nuova API
        }
    }
}