package exercises_part2.ex11;

public class Exercise11Step5 {
    public interface PaymentProcessor {
        void pay(double amount);
    }

    // Nuova API esterna (simulata)
    static class ModernApi {
        void chargeCreditCard(double val) {
            System.out.println("Modern API: " + val);
        }
    }

    public static class ModernPaymentAdapter implements PaymentProcessor {
        private ModernApi api = new ModernApi();

        @Override
        public void pay(double amount) {
            api.chargeCreditCard(amount);
        }
    }
}