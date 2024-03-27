package consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class After {
    public static class ProductManager {

        private List<Product> products;

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

    /**
     * We can use the Consumer of Product without writing new methods
     */
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 999.99),
                new Product("Phone", 699.99),
                new Product("Tablet", 399.99)
        );

        ProductManager productManager = new ProductManager();
        productManager.setProducts(products);

// Define a consumer that prints the name of each product
productManager.processProducts(
        product -> System.out.println(product.getName() + ": $" + product.getPrice())
);

        // Define a consumer that checks if a product is expensive (price > 500)
        productManager.processProducts(product -> {
            if (product.getPrice() > 500) {
                System.out.println(product.getName() + " is expensive.");
            } else {
                System.out.println(product.getName() + " is affordable.");
            }
        });

    }
}
