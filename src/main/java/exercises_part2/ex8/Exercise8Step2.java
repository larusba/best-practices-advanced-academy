package exercises_part2.ex8;

import java.util.ArrayList;
import java.util.List;

/**
 * STEP 2: DESIGN COMPOSITE (RED)
 * Creiamo un'interfaccia comune per Foglie (Prodotti) e Nodi (Menu).
 */
public class Exercise8Step2 {

    public interface MenuItem {
        double getPrice();
    }

    public static class Product implements MenuItem {
        private double price;

        public Product(double price) {
            this.price = price;
        }

        public double getPrice() {
            return 0; /* TODO */
        }
    }

    public static class Menu implements MenuItem {
        private List<MenuItem> children = new ArrayList<>();

        public void add(MenuItem item) {
            children.add(item);
        }

        public double getPrice() {
            return 0; /* TODO */
        }
    }
}