package exercises;

/**
 * Ex: try to increase cohesion and reduce coupling here
 * 
 * Coupling: degree of interdependence between modules or components in a system. 
 * Cohesion: how closely related and focused the responsibilities of elements within a module are. 
 */
public class Exercise2Before {
    // Order.java
    public static class Order {
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
    public static class Customer {
        private String customerId;
        private String name;

        // Constructors, getters, and setters
    }

    // PaymentProcessor.java
    public static class PaymentProcessor {
        public void printSomething() {
            System.out.println("PaymentProcessor.printSomething");
        }
        
        public void chargeCreditCard(Customer customer, double amount) {
            // Logic to process credit card payment
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Customer customer = new Customer();
            Order order = new Order(customer, 2.0);
            order.processPayment();
        }
    }
}
