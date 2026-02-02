package designpattern.facade;

/**
 * SOLUZIONE: Introduzione della Facade.
 *
 * La classe OrderFacade agisce come un'interfaccia unificata verso un insieme di interfacce
 * presenti nel sottosistema (Inventory, Payment, Shipping).
 *
 * VANTAGGI:
 * - Semplicità: Il Client chiama solo un metodo (placeOrder).
 * - Disaccoppiamento: Il Client non sa che esistono Inventory o Payment.
 * - Centralizzazione: La logica del flusso dell'ordine è centralizzata nella Facade.
 */
public class ExampleTwoAfter {

    /**
     * COMPONENT: Facade
     * Questa classe incapsula la complessità.
     * Offre un punto di accesso semplificato (un "Cruscotto") per il sistema di ordini.
     */
    public static class OrderFacade {
        /**
         * COMPONENT: Subsystems
         * I riferimenti ai sistemi complessi sono gestiti internamente.
         */
        private ExampleTwoBefore.Inventory inventory;
        private ExampleTwoBefore.Payment payment;
        private ExampleTwoBefore.Shipping shipping;

        public OrderFacade() {
            this.inventory = new ExampleTwoBefore.Inventory();
            this.payment = new ExampleTwoBefore.Payment();
            this.shipping = new ExampleTwoBefore.Shipping();
        }

        /**
         * Metodo Facade.
         * Esegue la sequenza corretta di operazioni ("Orchestrazione").
         */
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
             * Client Component.
             * Il codice client è ora pulitissimo.
             * Non deve preoccuparsi di inventari, pagamenti o spedizioni.
             * Sa solo che vuole piazzare un ordine.
             */
            OrderFacade orderFacade = new OrderFacade();
            String product = "Laptop";
            double amount = 1000.00;
            
            // Unica chiamata
            orderFacade.placeOrder(product, amount);
        }
    }

}