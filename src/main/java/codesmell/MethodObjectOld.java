package codesmell;

public class MethodObjectOld {
    static class Order {
        // …
        // a lot of code …
        // …
        public double price() {
            double primaryBasePrice = 0;
            double secondaryBasePrice = 0;
            double tertiaryBasePrice = 0;
            // Perform long computation.
            return primaryBasePrice + secondaryBasePrice + tertiaryBasePrice;
        }
    }
}
