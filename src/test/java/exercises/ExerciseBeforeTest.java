package exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * EX: 
 * - refactor this test
 * - check if there are false positives / negatives
 * - add possible additional tests
 */
class ExerciseBeforeTest {

    @Test
    void testDivideByZeroWithErrMsg() {
        LazyCalculator calculator = new LazyCalculator();
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
        );
    }

    @Test
    void testSubstract() {
        LazyCalculator lazyCalculator = new LazyCalculator();
        var result1 = lazyCalculator.substract(5, 3, true);
        Assertions.assertEquals(2, result1.getKey());
        Assertions.assertTrue(result1.getValue());

        var result2 = lazyCalculator.substract(15, 13, true);
        Assertions.assertEquals(2, result2.getKey());
        Assertions.assertTrue(result2.getValue());
        
        var result3 = lazyCalculator.substract(25, 23, false);
        Assertions.assertEquals(2, result1.getKey());
        assertTrue(!result3.getValue());
        
        var result4 = lazyCalculator.substract(1000, 1000, true);
        Assertions.assertEquals(0, result4.getKey());
        assertNull(result4.getValue());
    }

    @Test
    void testThatSubstractANumberMinusANumberIsEqualsZero() {
        LazyCalculator lazyCalculator = new LazyCalculator();
        var result = lazyCalculator.substract(2, 2, true);
        Assertions.assertEquals(0, result.getKey());
        
        var result1 = lazyCalculator.substract(200, 200, true);
        Assertions.assertEquals(0, result1.getKey());
        
        var result2 = lazyCalculator.substract(1000, 1000, true);
        Assertions.assertEquals(0, result2.getKey());
    }
}
