
package exercises;

/**
 * REFACTORING:
 * 1. **Strategy Pattern**: `PricingStrategy` incapsula le regole di prezzo (via gli if-else).
 * 2. **Dependency Injection**: `NotificationService` e `PricingStrategy` sono iniettati, rendendo la classe testabile.
 * 3. **SRP / Composition**: La validazione potrebbe essere estratta (qui semplificata in un metodo, ma separata logicamente).
 */
public class Exercise14After {

    public static class Order {
        String type;
        double amount;
        boolean isVerified;
        // constructor getters...
    }

    // --- 1. Astrazione della strategia di prezzo ---
    interface PricingStrategy {
        double calculate(double amount);
    }

    public static class B2BStrategy implements PricingStrategy {
        public double calculate(double amount) { return amount * 0.80; }
    }

    public static class GovStrategy implements PricingStrategy {
        public double calculate(double amount) { return amount; }
    }

    public static class B2CStrategy implements PricingStrategy {
        public double calculate(double amount) { return amount * 1.22; }
    }

    // --- 2. Astrazione della notifica ---
    interface NotificationService {
        void sendReceipt(double amount);
    }

    // --- 3. Service rifattorizzato ---
    public static class OrderService {
        private final NotificationService notificationService;

        // Dependency Injection tramite costruttore
        public OrderService(NotificationService notificationService) {
            this.notificationService = notificationService;
        }

        // Il metodo ora "orchestra" il lavoro invece di farlo tutto da solo
        public void processOrder(Order order, PricingStrategy pricingStrategy) {
            validate(order);

            double finalPrice = pricingStrategy.calculate(order.amount);
            System.out.println("Order processed. Final Price: " + finalPrice);

            notificationService.sendReceipt(finalPrice);
        }

        private void validate(Order order) {
            if (order.amount <= 0) throw new IllegalArgumentException("Invalid amount");
            if (!order.isVerified) throw new IllegalStateException("User not verified");
        }
    }

    // Esempio di utilizzo (Client Code)
    public static void main(String[] args) {
        // Setup delle dipendenze
        NotificationService emailer = amount -> System.out.println("Emailing receipt: " + amount);
        OrderService service = new OrderService(emailer);

        Order b2bOrder = new Order(); // ... setup order
        b2bOrder.amount = 100;
        b2bOrder.isVerified = true;

        // Inietto la strategia specifica per questo ordine (Polimorfismo)
        service.processOrder(b2bOrder, new B2BStrategy());
    }
}