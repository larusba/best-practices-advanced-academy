package consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * SOLUZIONE: Utilizzo di java.util.function.Consumer.
 *
 * Abbiamo separato la logica di iterazione (che rimane nel ProductManager)
 * dalla logica di business (l'azione da compiere sul singolo prodotto).
 *
 * VANTAGGI:
 * - Parametrizzazione del Comportamento: L'azione è passata come argomento.
 * - Riutilizzo: Un solo metodo 'processProducts' gestisce infinite casistiche.
 * - Open/Closed Principle: Possiamo inventare nuovi "Consumer" nel client
 * senza mai dover modificare la classe ProductManager.
 */
public class After {
    public static class ProductManager {

        private List<Product> products;

        /**
         * Metodo Generico.
         * Accetta un comportamento (Consumer) e lo applica a ogni elemento.
         * Non sa "cosa" sta facendo, sa solo che deve applicarlo a tutti.
         */
        public void processProducts(Consumer<Product> productConsumer) {
            for (Product product : products) {
                // Apply the consumer to each product
                productConsumer.accept(product);
            }
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }
    }

    /** We can use the Consumer of Product without writing new methods */
    public static void main(String[] args) {
        List<Product> products =
                Arrays.asList(
                        new Product("Laptop", 999.99),
                        new Product("Phone", 699.99),
                        new Product("Tablet", 399.99));

        ProductManager productManager = new ProductManager();
        productManager.setProducts(products);

        // Caso 1: Passiamo un comportamento di stampa (Lambda Expression)
        productManager.processProducts(
                product -> System.out.println(product.getName() + ": $" + product.getPrice()));

        // Caso 2: Passiamo un comportamento di verifica prezzo
        // Non abbiamo dovuto modificare ProductManager per supportare questa nuova logica
        productManager.processProducts(
                product -> {
                    if (product.getPrice() > 500) {
                        System.out.println(product.getName() + " is expensive.");
                    } else {
                        System.out.println(product.getName() + " is affordable.");
                    }
                });
    }
}