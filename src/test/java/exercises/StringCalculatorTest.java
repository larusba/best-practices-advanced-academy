package exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static exercises.StringCalculator.NEGATIVI_NON_AMMESSI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 🛠️ Esercizio 1: String Calculator
 *
 * Obiettivo: Implementare una calcolatrice che accetta una stringa e restituisce la somma dei numeri.
 *
 * REQUISITI (Da implementare uno alla volta con TDD):
 *
 * 1. Il metodo accetta una stringa "numbers" e ritorna un int.
 * 2. Input "" (stringa vuota) ==> Ritorna 0.
 * 3. Input "1" (singolo numero) ==> Ritorna 1.
 * 4. Input "1,2" (due numeri) ==> Ritorna 3.
 * 5. Input "1,2,3,4" (n numeri) ==> Ritorna somma (10).
 * 6. Input "1\n2,3" (accetta \n come separatore) ==> Ritorna 6.
 *
 * REQUISITI IPOTETICI RICHIESTI IN SEGUITO:
 * A. Input "1,-2" (negativi) ==> Lancia IllegalArgumentException("Negativi non ammessi: -2").
 * B. Input "2,1001" (numeri > 1000) ==> Ignora i numeri > 1000 (Ritorna 2).
 */
public class StringCalculatorTest {
    StringCalculator calculator;
    
    @BeforeEach
    void beforeEach() {
        calculator = new StringCalculator();
    }
    
    @Test
    void testReturnNumbers() {
        int add = calculator.add("");
        assertEquals(0, add);
    }
    
    @Test
    void testSingleNumber() {
        int add = calculator.add("1");
        assertEquals(1, add);
    }

    @Test
    void testMultipleNumbers() {
        int add = calculator.add("1,2,3,4");
        assertEquals(10, add);
    }

    @Test
    void testMultipleNumbersWithNewLine() {
        int add = calculator.add("1\n2,3");
        assertEquals(6, add);
    }

    @Test
    void testNegativeNumbers() {
        try {
            int add = calculator.add("1,-2,-3");
            fail("should fail due to negative numbers");
        } catch (Exception e) {
            assertEquals(NEGATIVI_NON_AMMESSI, e.getMessage());
        }
    }

    @Test
    void testIgnoreNumbersGreaterThan1000() {
        int add = calculator.add("1,2,3,4,1001");
        assertEquals(10, add);
    }
}
