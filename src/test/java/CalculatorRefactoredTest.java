//import static org.junit.Assert.assertEquals;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class CalculatorRefactoredTest {
//
//    /** TODO : exercise: optimize something like here --> */
//    private Calculator calculator;
//
//    /**
//     * Setup Method (@Before): I introduced a setUp method annotated with @Before. This method is
//     * executed before each test method and is used to set up common objects or configurations. In
//     * this case, it creates an instance of the Calculator class, reducing code duplication.
//     *
//     * <p>Instance Variable for Calculator: I moved the Calculator instantiation to an instance
//     * variable (calculator) to avoid duplicating the code in each test method. This promotes code
//     * reuse and makes the test class cleaner.
//     *
//     * <p>By refactoring the test class, we've made it more maintainable and reduced redundancy. The
//     * use of @Before ensures that each test starts with a fresh instance of the Calculator class,
//     * and any changes to the instantiation or setup can be done in a single place.
//     */
//    @Before
//    public void setUp() {
//        calculator = new Calculator();
//    }
//
//    @Test
//    public void testAddition() {
//        assertEquals(5, calculator.add(2, 3));
//    }
//
//    @Test
//    public void testSubtraction() {
//        assertEquals(2, calculator.subtract(5, 3));
//    }
//
//    @Test
//    public void testMultiplication() {
//        assertEquals(15, calculator.multiply(3, 5));
//    }
//
//    @Test
//    public void testDivision() {
//        assertEquals(4, calculator.divide(8, 2));
//    }
//}
