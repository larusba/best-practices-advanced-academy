package exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Refactor this code.
 * In particular, decouple the Customer class
 */
public class Exercise4Before {

    // Warehouse class
    public static class Warehouse {
        private List<Order> orders = new ArrayList<>();

        public void addOrder(Order order) {
            orders.add(order);
        }

        public void processOrder(Order order) {
            if (orders.contains(order)) {
                System.out.println("Processing order: " + order.getId());
            } else {
                System.out.println("Invalid order.");
            }
        }
    }

    // PaymentSystem class
    public static class PaymentSystem {
        public void processPayment(Order order) {
            System.out.println("Processing payment for order: " + order.getId());
        }
    }

    // ShippingSystem class
    public static class ShippingSystem {
        public void shipOrder(Order order) {
            System.out.println("Shipping order: " + order.getId());
        }
    }

    // Order class
    public static class Order {
        private int id;

        public Order(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    // Customer class
    public static class Customer {
        private String name;

        public Customer(String name) {
            this.name = name;
        }

        public void placeOrder(Warehouse warehouse, PaymentSystem paymentSystem, ShippingSystem shippingSystem, Order order) {
            warehouse.addOrder(order);
            paymentSystem.processPayment(order);
            shippingSystem.shipOrder(order);
        }
    }

    // Main class
    public static class Main {
        public static void main(String[] args) {
            Warehouse warehouse = new Warehouse();
            PaymentSystem paymentSystem = new PaymentSystem();
            ShippingSystem shippingSystem = new ShippingSystem();
            Order order1 = new Order(1);
            Order order2 = new Order(2);

            Customer customer = new Customer("Alice");
            customer.placeOrder(warehouse, paymentSystem, shippingSystem, order1);
            customer.placeOrder(warehouse, paymentSystem, shippingSystem, order2);

            warehouse.processOrder(order1);
        }
    }



}
