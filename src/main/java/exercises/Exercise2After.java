package exercises;

/**
 * more modular and maintainable design by adhering to the principles,
 * since inject the `PaymentProcessor paymentProcessor`
 * aggiunto parametro in Order, ma ora è più modulare visto che paymentProcessor può fare altro, non è legato da processPayment() 
 * 
 * // we have 2 PaymentProcessor in Main that do different stuff (i.e. printSomething())
 */
public class Exercise2After {
    // Order.java
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
