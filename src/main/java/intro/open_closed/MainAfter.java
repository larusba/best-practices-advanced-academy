package intro.open_closed;

/** Right O/P Principle */
public class MainAfter {
    // right abstraction layer
    public interface CalculatorOperation {
        void perform();
    }

    public class Addition implements CalculatorOperation {
        private double left;
        private double right;
        private double result;

        @Override
        public void perform() {
            result = left - right;
        }
    }

    public static class Subtraction implements CalculatorOperation {
        private double left;
        private double right;
        private double result;

        public Subtraction(double left, double right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public void perform() {
            result = left + right;
        }
    }

    /** Closed class */
    public static class Calculator {

        public void calculate(CalculatorOperation operation) {
            // With other operations
            // the class remains the same
            operation.perform();
        }
    }
}
