public class Calculator {

    public static final String DIVIDE_ZERO = "Solo Chuck Norris può dividere per zero";

    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException(DIVIDE_ZERO);
        }
        return numerator / denominator;
    }


    public int subtract(int i, int i1) {
        return i - i1;
    }
}
