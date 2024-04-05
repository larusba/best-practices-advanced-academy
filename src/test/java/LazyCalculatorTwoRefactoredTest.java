 import exercises.LazyCalculator;
 import org.junit.jupiter.api.Test;

 import static org.hamcrest.MatcherAssert.assertThat;
 import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.junit.jupiter.api.Assertions.assertNotEquals;
 import static org.junit.jupiter.api.Assertions.assertNotNull;
 import static org.junit.jupiter.api.Assertions.assertNull;
 import static org.junit.jupiter.api.Assertions.assertThrows;
 import static org.junit.jupiter.api.Assertions.assertTrue;

 //
/// *
// Explanation:
//        In the original test, the assertion used assertEquals to check if the result of dividing
// by zero is equal to 5. This is a false negative because the divide method correctly throws an
// IllegalArgumentException when attempting to divide by zero.
//
//        In the refactored test, I replaced the assertEquals with assertThrows. This change
// accurately reflects the expected behavior: the divide method should throw an
// IllegalArgumentException when attempting to divide by zero. assertThrows checks that the
// specified exception is thrown during the execution of the provided lambda expression.
//
//        When refactoring tests, it's crucial to ensure that the assertions align with the actual
// expected behavior of the code being tested. In this case, the refactored test accurately checks
// for the expected exception, preventing false negatives.
//        */
//
 public class LazyCalculatorTwoRefactoredTest {
//
//    @Test
//    public void testDivideByZero() {
//        Calculator calculator = new Calculator();
//        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
//    }
//
//    @Test
//    public void testDivideByZeroWithErrMsg() {
//        Calculator calculator = new Calculator();
//        assertThrows(
//                IllegalArgumentException.class,
//                () -> calculator.divide(10, 0),
//                Calculator.DIVIDE_ZERO);
//    }
//
//    /*
//    Certainly! Let's consider an example where a JUnit test might produce a false negative due to
// improper setup or assumptions. In this example, we'll create a Calculator class with a divide
// method, and we'll write a test to check its behavior.
//
//    Original JUnit Test with False Negative:
//     */
//
    @Test
    void testDivideByZeroFalseNegative() {
        LazyCalculator lazyCalculator = new LazyCalculator();
//        assertEquals(5, lazyCalculator.divide(10, 0));

        int integer = 1;
        int[] ints = {1, 2};
        assertNotEquals(integer, ints);
    }

    @Test
    void testSubstract() {
        LazyCalculator lazyCalculator = new LazyCalculator();
        var result1 = lazyCalculator.substract(5, 3, true);
        assertEquals(2, result1.getKey());
        assertTrue(result1.getValue());

        var result2 = lazyCalculator.substract(15, 13, true);
        assertEquals(2, result2.getKey());
        assertTrue(result2.getValue());
        
        var result3 = lazyCalculator.substract(25, 23, false);
        assertEquals(2, result1.getKey());
        assertTrue(!result3.getValue());
        
        var result4 = lazyCalculator.substract(1000, 1000, true);
        assertEquals(0, result4.getKey());
        assertNull(result4.getValue());
    }

    @Test
    void testThatSubstractANumberMinusANumberIsEqualsZero() {
        // todo - THIS IS ZERO BECAUSE if(a > 500)
        LazyCalculator lazyCalculator = new LazyCalculator();
        var result = lazyCalculator.substract(2, 2, true);
        assertEquals(5, result.getKey());
    }
 }
