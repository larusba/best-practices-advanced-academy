package exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExerciseAfterTest {
    
    private static LazyCalculator lazyCalculator;
    
    @BeforeAll
    public static void beforeAll() {
        lazyCalculator = new LazyCalculator();
    }

    @Test
    void testDivideByZeroWithErrMsg() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> lazyCalculator.divide(10, 0),
                LazyCalculator.DIVIDE_ZERO);
    }

    @Test
    void testNumeratorGreaterThan2000WithErrMsg() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> lazyCalculator.divide(9999, 0),
                LazyCalculator.NUMERATOR_TOO_BIG);
    }

    @Test
    void testDenominatorGreaterThan2000WithErrMsg() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> lazyCalculator.divide(10, 9999),
                LazyCalculator.NUMERATOR_TOO_BIG);
    }

    /**
     * NB: false positive --> result3 and after result1
     *         var result3 = lazyCalculator.substract(25, 23, false);
     *         Assertions.assertEquals(2, result1.getKey());
     */
    @Test
    void testSubstract() {
        var result1 = lazyCalculator.substract(5, 3, true);
        assertEquals(2, result1.getKey());
        assertTrue(result1.getValue());

        var result2 = lazyCalculator.substract(15, 13, true);
        assertEquals(2, result2.getKey());
        assertTrue(result2.getValue());
        
        var result3 = lazyCalculator.substract(25, 23, false);
        assertEquals(2, result3.getKey());
        assertFalse(result3.getValue());
        
        var result4 = lazyCalculator.substract(1000, 1000, true);
        assertEquals(0, result4.getKey());
        assertNull(result4.getValue());
    }

    @Test
    void testThatSubstractANumberMinusANumberIsEqualsZero() {
        LazyCalculator lazyCalculator = new LazyCalculator();
        var result = lazyCalculator.substract(2, 2, true);
        Assertions.assertEquals(0, result.getKey());

        var result1 = lazyCalculator.substract(200, 200, true);
        Assertions.assertEquals(0, result1.getKey());
    }

    /**
     * NB:
     * lazyCalculator.substract(1000, 1000, true) is 0 because numbers are greater than 500, so another test
     * false positive
     */
    @Test
    void testThatWithNumberGreaterThan500TheResultIsZero() {
        var result = lazyCalculator.substract(1000, 1000, true);
        assertEquals(0, result.getKey());
    }
}
