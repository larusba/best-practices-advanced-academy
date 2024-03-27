package intro.open_closed;

/** Wrong O/P Principle */
public class MainBefore {
    public interface CalculatorOperation {
        void setResult(double result);
    }

    public static class Addition implements CalculatorOperation {
        private double left;
        private double right;
        private double result;

        public Addition(double left, double right) {
            this.left = left;
            this.right = right;
        }

        public double getLeft() {
            return left;
        }

        public double getRight() {
            return right;
        }

        @Override
        public void setResult(double result) {
            this.result = result;
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

        public double getLeft() {
            return left;
        }

        public double getRight() {
            return right;
        }

        @Override
        public void setResult(double result) {
            this.result = result;
        }
    }

    /** Not-closed class */
    public static class Calculator {

        public void calculate(CalculatorOperation operation) {

            // With other operations, e.g. `Division` we should create other setResult
            if (operation instanceof Addition) {
                Addition addition = (Addition) operation;
                addition.setResult(addition.getLeft() + addition.getRight());
            } else if (operation instanceof Subtraction) {
                Subtraction subtraction = (Subtraction) operation;
                subtraction.setResult(subtraction.getLeft() - subtraction.getRight());
            }
        }
    }
}
