import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

//    @Test
//    public void testAddition() {
//        Calculator calculator = new Calculator();
//        assertEquals(5, calculator.add(2, 3));
//    }

    @Test
    public void testSubtraction() {
        
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(5, 3));
    }

//    @Test
//    public void testMultiplication() {
//        Calculator calculator = new Calculator();
//        assertEquals(15, calculator.multiply(3, 5));
//    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.divide(8, 2));
    }

    class RunnableWithAnAssertion extends Thread {
        @Override
        public void run() {
            assertEquals(expected, actual);  // Noncompliant
        }

        @Test
        void test() {
            RunnableWithAnAssertion otherThread = new RunnableWithAnAssertion();
            otherThread.start();
            // ...
            // The failed assertions in the run method will prevent us from reaching the assertion below
            // ...
            assertTrue(true);
        }
    }
}
