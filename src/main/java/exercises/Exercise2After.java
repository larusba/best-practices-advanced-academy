package exercises;

/**
 * Dependency Injection (tramite costruttore), 
 * rimuovendo l'istanziazione diretta (new) della dipendenza all'interno della classe Order (Inversion of Control).
 * Questo riduce il Coupling (accoppiamento), 
 * poiché Order non è più responsabile della creazione del PaymentProcessor, 
 * vedi: `PaymentProcessor paymentProcessor = new PaymentProcessor();`
 * ma lo riceve già pronto dall'esterno.
 */
public class Exercise2After {
    public static class Order {
        private Customer customer;
        private double totalPrice;
        private PaymentProcessor paymentProcessor;

        public Order(Customer customer, double totalPrice, PaymentProcessor paymentProcessor) {
            this.customer = customer;
            this.totalPrice = totalPrice;
            this.paymentProcessor = paymentProcessor;
        }

        public void processPayment() {
            paymentProcessor.chargeCreditCard(customer, totalPrice);
        }
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



    // Customer.java
    public static class Customer {
        private String customerId;
        private String name;

        // Constructors, getters, and setters
    }

    public static class Main {
        public static void main(String[] args) {

            Customer customer = new Customer();
            PaymentProcessor paymentProcessor = new PaymentProcessor();
            Order order = new Order(customer, 2.0, paymentProcessor);
            order.processPayment();


            PaymentProcessor paymentProcessor2 = new PaymentProcessor();
            paymentProcessor2.printSomething();
            Order order2 = new Order(customer, 2.0, paymentProcessor);
            order.processPayment();
        }
    }
}
