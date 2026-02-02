package designpattern.facade;

/**
 * PROBLEMA: Complessità esposta al Client.
 *
 * In questo scenario "senza Facade", il Client (la classe Main) deve coordinare
 * manualmente tutti i sottosistemi necessari per completare un ordine.
 *
 * CRITICITÀ:
 * - Accoppiamento Stretto: Il Client dipende direttamente da Inventory, Payment e Shipping.
 * - Violazione dell'Incapsulamento: La logica di business ("prima controlla, poi paga, poi spedisci")
 * risiede nel Client, non nel sistema.
 * - Difficoltà d'uso: Chi vuole fare un ordine deve sapere esattamente quali classi chiamare e in che ordine.
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
            // CODE SMELL: Il Client deve istanziare e coordinare tutto manualmente.
            Inventory inventory = new Inventory();
            Payment payment = new Payment();
            Shipping shipping = new Shipping();

            String product = "Laptop";
            
            // Se cambiasse l'ordine delle operazioni (es. prima paghi, poi check),
            // dovremmo modificare il codice di tutti i Client.
            inventory.checkInventory(product);
            payment.processPayment(1000.00);
            shipping.shipProduct(product);
        }
    }

}