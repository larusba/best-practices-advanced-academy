package exercises_part2.ex8;
import java.util.ArrayList;
import java.util.List;

public class Exercise8Step4 {
    public interface MenuItem { double getPrice(); }
    public static class Product implements MenuItem { 
        double p; public Product(double p){this.p=p;} public double getPrice(){return p;} 
    }
    
    // Stub del Menu Scontato
    public static class DiscountMenu implements MenuItem {
        private List<MenuItem> children = new ArrayList<>();
        public void add(MenuItem item) { children.add(item); }
        
        public double getPrice() { return 0; /* TODO */ }
    }
}