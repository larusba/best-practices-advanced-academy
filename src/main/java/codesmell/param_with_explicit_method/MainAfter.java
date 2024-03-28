package codesmell.param_with_explicit_method;

public class MainAfter {
    static class Order {
        private double price;

        public Order(double price) {
            this.price = price;
        }
        
        // ...
        public void applyFixedDiscount(double discount) {
            price -= discount;
        }
        public void applyPercentDiscount(double discount) {
            price *= discount;
        }
    }



    public static void main(String[] args) {
        // ideally a method..
        boolean weekend = true;

        Order order = new Order(12.34);
        
        
        // Somewhere in client code
        if (weekend) {
            order.applyFixedDiscount(10);
        } else {
            order.applyPercentDiscount(0.2);
        }
    }
}


