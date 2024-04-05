package exercises;

/**
 * EX: refactor by adding these features: gift wrap and shipping cost,
 * that increase the cost of the base product by 5 and 10 respectively.
 */
public class Exercise5Before {
    // Original product class
    public static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getDescription() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Product shirt = new Product("Shirt", 29.99);
            Product laptop = new Product("Laptop", 999.99);

            System.out.println(shirt.getDescription() + " - $" + shirt.getPrice());
            System.out.println(laptop.getDescription() + " - $" + laptop.getPrice());
        }
    }

}
