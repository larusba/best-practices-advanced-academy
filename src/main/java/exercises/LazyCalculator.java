package exercises;

import java.util.AbstractMap;
import java.util.Map;

/**
 * NOTE: Used in src/test/java/exercises
 */
public class LazyCalculator {

    public static final String DIVIDE_ZERO = "Solo Chuck Norris può dividere per zero";
    public static final String NUMERATOR_TOO_BIG = "Numerator too big, I don't wanna divide, I'm tired. Try something smaller";
    public static final String DENOMINATOR_TOO_BIG = "Denominator too big, I don't wanna divide, I'm tired. Try something smaller";

    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException(DIVIDE_ZERO);
        }
        
        if (numerator > 2000) {
            throw new IllegalArgumentException(NUMERATOR_TOO_BIG);
        }
        
        if (denominator > 2000) {
            throw new IllegalArgumentException(DENOMINATOR_TOO_BIG);
        }
        
        return numerator / denominator;
    }


    public Map.Entry<Integer, Boolean> substract(int a, int b, boolean mockCheck) {
        if (a > 500 || b > 500) {
            System.out.println("the numbers are too big, I'll return 0 because I'm too tired");
            return new AbstractMap.SimpleEntry(0, null);
        }
        
        return new AbstractMap.SimpleEntry(a - b, mockCheck);
    }
}
