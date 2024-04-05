package consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Before {
    public static class ProductManager {

        private List<Product> products;

        /** We use 2 similar methods, each cycle the product */
        public void processProductsPrint() {
            for (Product product : products) {
                System.out.println(product.getName() + ": $" + product.getPrice());
            }
        }

        /** We use 2 similar methods, each cycle the product */
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
