package exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static exercises.LazyCalculator.DIVIDE_ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * TODO
 */
class ExerciseAfterTest {
    private static LazyCalculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = new LazyCalculator();
    }
    
    
    @Test
    void testDivideByZeroWithErrMsg() {
        
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0),
                DIVIDE_ZERO
        );
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 2",
            "15, 13, 2",
            "30, 20, 10"
    })
    void testSubstract(int a, int b, int c) {
        var result1 = calculator.substract(a, b, true);
        assertEquals(c, result1.getKey());
        assertTrue(result1.getValue());
    }



    @Test
    void testThatSubstractANumberMinusANumberIsEqualsZero() {
        var result = calculator.substract(2, 2, true);
        assertEquals(0, result.getKey());

        var result1 = calculator.substract(200, 200, true);
        assertEquals(0, result1.getKey());
    }

    @Test
    void testThatWithNumberGreaterThan500TheResultIsZero() {
        var result = calculator.substract(1000, 900, true);
        assertEquals(0, result.getKey());
    }
}

