package designpattern.facade;

/**
 * Ecommerce like example
 */
public class ExampleTwoBefore {
    // Subsystem 1: Inventory
    public static class Inventory {
        public void checkInventory(String product) {
            System.out.println("Checking inventory for product: " + product);
        }
    }


    public static class Payment {
        public void processPayment(double amount) {
            System.out.println("Processing payment of amount: " + amount);
        }
    }
    
    public static class Shipping {
        public void shipProduct(String product) {
            System.out.println("Shipping product: " + product);
        }
    }

    // Usage
    public static class Main {
        public static void main(String[] args) {
            // Order placement without Facade
            Inventory inventory = new Inventory();
            Payment payment = new Payment();
            Shipping shipping = new Shipping();

            String product = "Laptop";
            inventory.checkInventory(product);
            payment.processPayment(1000.00);
            shipping.shipProduct(product);
        }
    }

}
