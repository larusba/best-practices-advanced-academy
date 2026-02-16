package exercises;


import java.util.ArrayList;
import java.util.List;

/**
 * Mediator Pattern 
 * per disaccoppiare la classe Customer dalla gestione diretta dei vari sottosistemi (Warehouse, PaymentSystem, ShippingSystem).
 * Nel "Before", il Customer agiva da orchestratore (alto accoppiamento); nell'"After", il Customer comunica solo con l'interfaccia OrderMediator, delegando a quest'ultima la gestione delle operazioni e rendendo il codice più mantenibile e meno dipendente dalle implementazioni specifiche.
 */
public class Exercise4After {
    /**
     * Mediator Interface: We introduced an OrderMediator interface to define the mediator's responsibilities.
     * Concrete Mediator Classes: We created separate mediator classes (Warehouse, PaymentSystem, ShippingSystem) that implement the OrderMediator interface. 
     * Each mediator is responsible for specific tasks related to orders.
     * Order Class Refactoring: The Order class remains unchanged.
     * Customer Class Refactoring: The Customer class now contains a reference to the
     */

    // Mediator interface
    interface OrderMediator {
        void addOrder(Order order);
        void processOrder(Order order);
    }

    public static class Warehouse implements OrderMediator {
        private List<Order> orders = new ArrayList<>();

        @Override
        public void addOrder(Order order) {
            orders.add(order);
        }

        @Override
        public void processOrder(Order order) {
            if (orders.contains(order)) {
                System.out.println("Warehouse: Processing order: " + order.getId());
            } else {
                System.out.println("Warehouse: Invalid order.");
            }
        }
    }

    public static class PaymentSystem implements OrderMediator {
        @Override
        public void addOrder(Order order) {
            System.out.println("Payment System: Adding order: " + order.getId());
        }

        @Override
        public void processOrder(Order order) {
            System.out.println("Payment System: Processing payment for order: " + order.getId());
        }
    }

    public static class ShippingSystem implements OrderMediator {
        @Override
        public void addOrder(Order order) {
            System.out.println("Shipping System: Adding order: " + order.getId());
        }

        @Override
        public void processOrder(Order order) {
            System.out.println("Shipping System: Shipping order: " + order.getId());
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
        private OrderMediator mediator;

        public Customer(String name, OrderMediator mediator) {
            this.name = name;
            this.mediator = mediator;
        }

        public void placeOrder(Order order) {
            mediator.addOrder(order);
            mediator.processOrder(order);
        }
    }

    // Main class
    public static class Main {
        public static void main(String[] args) {
            OrderMediator warehouse = new Warehouse();
            Order order1 = new Order(1);
            Order order2 = new Order(2);

            Customer customer = new Customer("Alice", warehouse);
            customer.placeOrder(order1);
            customer.placeOrder(order2);
        }
    }

}
