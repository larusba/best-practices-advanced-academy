package exercises;

/**
 * ESERCIZIO COMPLESSO:
 * Questa classe viola il Single Responsibility Principle (SRP).
 * Fa validazione, calcoli complessi (business logic) e notifiche (infrastructure).
 * Inoltre, è difficile da testare perché crea le dipendenze internamente (new EmailService).
 */
public class Exercise14Before {

    // Dipendenza hardcoded
    public static class EmailService {
        public void sendEmail(String msg) { System.out.println("Sending: " + msg); }
    }

    public static class Order {
        String type; // "B2B", "B2C", "GOV"
        double amount;
        boolean isVerified;
        // constructor...
    }

    public static class OrderService {

        public void processOrder(Order order) {
            // 1. Validazione mescolata
            if (order.amount <= 0) throw new IllegalArgumentException("Invalid amount");
            if (!order.isVerified) throw new IllegalStateException("User not verified");

            // 2. Calcolo prezzo (Logica condizionale complessa -> Strategy candidate)
            double finalPrice;
            if (order.type.equals("B2B")) {
                finalPrice = order.amount * 0.80; // 20% sconto
            } else if (order.type.equals("GOV")) {
                finalPrice = order.amount; // Nessuna tassa
            } else {
                finalPrice = order.amount * 1.22; // B2C + IVA
            }

            System.out.println("Order processed. Final Price: " + finalPrice);

            // 3. Notifica (Dipendenza stretta)
            EmailService emailService = new EmailService();
            emailService.sendEmail("Receipt for " + finalPrice);
        }
    }
}
