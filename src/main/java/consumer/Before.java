package consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * PROBLEMA: Duplicazione della Logica di Iterazione.
 *
 * Questa classe viola il principio DRY (Don't Repeat Yourself) perché ripete
 * la struttura del ciclo (for-each) per ogni diversa operazione che si vuole
 * eseguire sui prodotti.
 *
 * CRITICITÀ:
 * - Rigidità: Per aggiungere una nuova operazione (es. "salva su DB"), dobbiamo
 * modificare la classe ProductManager aggiungendo un nuovo metodo e duplicando il ciclo.
 * - Manutenibilità: Se cambia il modo in cui iteriamo (es. vogliamo farlo in parallelo),
 * dobbiamo modificare tutti i metodi singolarmente.
 */
public class Before {
    public static class ProductManager {

        private List<Product> products;

        /**
         * CODE SMELL: Metodo specifico hardcoded.
         * Itera e stampa. Il ciclo è accoppiato all'azione di stampa.
         */
        public void processProductsPrint() {
            for (Product product : products) {
                System.out.println(product.getName() + ": $" + product.getPrice());
            }
        }

        /**
         * CODE SMELL: Duplicazione del ciclo.
         * Itera e controlla il prezzo. Stesso ciclo, azione diversa.
         */
        public void processProductsCheckPrice() {
            for (Product product : products) {
                if (product.getPrice() > 500) {
                    System.out.println(product.getName() + " is expensive.");
                } else {
                    System.out.println(product.getName() + " is affordable.");
                }
            }
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }
    }

    public static void main(String[] args) {
        List<Product> products =
                Arrays.asList(
                        new Product("Laptop", 999.99),
                        new Product("Phone", 699.99),
                        new Product("Tablet", 399.99));

        ProductManager productManager = new ProductManager();
        productManager.setProducts(products);

        // Define a consumer that prints the name of each product
        productManager.processProductsPrint();

        productManager.processProductsCheckPrice();

        // Define a consumer that does some other operation
        Consumer<Product> otherOperationConsumer =
                product -> {
                    // Some other operation
                    System.out.println("Doing some other operation with " + product.getName());
                };
    }
}