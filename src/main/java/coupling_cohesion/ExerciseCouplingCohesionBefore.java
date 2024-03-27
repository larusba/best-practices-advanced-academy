package coupling_cohesion;

/**
 * Issues: High Coupling: The Order class directly creates an instance of PaymentProcessor, leading
 * to tight coupling. Changes in the PaymentProcessor implementation may impact the Order class.
 *
 * <p>Low Cohesion: The Order class is responsible for both order details and payment processing,
 * violating the single responsibility principle and reducing cohesion.
 */
public class ExerciseCouplingCohesionBefore {
    // Order.java
    public class Order {
        private Customer customer;
        private double totalPrice;

        public Order(Customer customer, double totalPrice) {
            this.customer = customer;
            this.totalPrice = totalPrice;
        }

        public void processPayment() {
            PaymentProcessor paymentProcessor = new PaymentProcessor();
            paymentProcessor.chargeCreditCard(customer, totalPrice);
        }
    }

    // Customer.java
    public class Customer {
        private String customerId;
        private String name;

        // Constructors, getters, and setters
    }

    // PaymentProcessor.java
    public class PaymentProcessor {
        public void chargeCreditCard(Customer customer, double amount) {

            // Logic to process credit card payment
        }
    }
}
