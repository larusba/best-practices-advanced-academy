package designpattern.facade;

public class ExampleTwoAfter {

    /**
     * COMPONENT: Facade component
     * the facade encapsulates the complexities of the subsystems and provides a cleaner, 
     * more intuitive interface for the client code.
     */
    public static class OrderFacade {
        /**
         * COMPONENT: Subsystems
         */
        private ExampleTwoBefore.Inventory inventory;
        private ExampleTwoBefore.Payment payment;
        private ExampleTwoBefore.Shipping shipping;

        public OrderFacade() {
            this.inventory = new ExampleTwoBefore.Inventory();
            this.payment = new ExampleTwoBefore.Payment();
            this.shipping = new ExampleTwoBefore.Shipping();
        }

        public void placeOrder(String product, double amount) {
            inventory.checkInventory(product);
            payment.processPayment(amount);
            shipping.shipProduct(product);
        }
    }

    // Usage
    public class Main {
        public static void main(String[] args) {
            // Order placement with Facade
            /**
             * Client component
             */
            OrderFacade orderFacade = new OrderFacade();
            String product = "Laptop";
            double amount = 1000.00;
            orderFacade.placeOrder(product, amount);
        }
    }

}
