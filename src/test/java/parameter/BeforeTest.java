package parameter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static parameter.Main.TaxCalculator.*;
import static parameter.Main.Game.*;

import org.junit.jupiter.api.Test;

class BeforeTest {
    @Test
    void test_not_null1() {  // Noncompliant. The 3 following tests differ only by one hardcoded number.
        setupTax();
        assertNotNull(getTax(1));
    }

    @Test
    void test_not_null2() {
        setupTax();
        assertNotNull(getTax(2));
    }

    @Test
    void test_not_null3() {
        setupTax();
        assertNotNull(getTax(3));
    }

    @Test
    void testLevel1() {  // Noncompliant. The 3 following tests differ only by a few hardcoded numbers.
        setLevel(1);
        runGame();
        assertEquals(playerHealth(), 100);
    }

    @Test
    void testLevel2() {  // Similar test
        setLevel(2);
        runGame();
        assertEquals(playerHealth(), 200);
    }

    @Test
    void testLevel3() {  // Similar test
        setLevel(3);
        runGame();
        assertEquals(playerHealth(), 300);
    }
}