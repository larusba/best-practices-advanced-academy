package codesmell; // package codesmell;
//
// public class MethodObject {
//    class Order {
//        // …
//        // a lot of code …
//        // …
//        public double price() {
//            return new PriceCalculator(this).compute();
//        }
//    }
//    class PriceCalculator {
//        private double primaryBasePrice;
//        private double secondaryBasePrice;
//        private double tertiaryBasePrice;
//
//        public PriceCalculator(Order order) {
//            // Copy relevant information from the
//            // order object.
//        }
//
//        public double compute() {
//            // Perform long computation.
//        }
//    }
//
//
// }
