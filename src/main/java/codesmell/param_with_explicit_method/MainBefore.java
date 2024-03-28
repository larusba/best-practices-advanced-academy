package codesmell.param_with_explicit_method;

public class MainBefore {
    static class Order {
        private double price;

        public Order(double price) {
            this.price = price;
        }

        // ...
        public static final int FIXED_DISCOUNT = 0;
        public static final int PERCENT_DISCOUNT = 1;

        public void applyDiscount(int type, double discount) {
            switch (type) {
                case FIXED_DISCOUNT:
                    price -= discount;
                    break;
                case PERCENT_DISCOUNT:
                    price *= discount;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid discount type");
            }
        }
    }



    public static void main(String[] args) {
        // ideally a method..
        boolean weekend = true;
                
        Order order = new Order(12.34);
        
        
        // Somewhere in client code
        if (weekend) {
            order.applyDiscount(Order.FIXED_DISCOUNT, 10);
        } else {
            order.applyDiscount(Order.PERCENT_DISCOUNT, 0.2);
        }
    }
}


