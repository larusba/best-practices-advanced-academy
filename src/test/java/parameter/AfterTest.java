package parameter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static parameter.Main.Game.*;
import static parameter.Main.TaxCalculator.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AfterTest {

    // single parameter with values 1,2,3
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void test_not_null(int arg) {
        setupTax();
        assertNotNull(getTax(arg));
    }

    // multiple set of parameters comma-separated
    @ParameterizedTest
    @CsvSource({
        "1, 100",
        "2, 200",
        "3, 300",
    })
    void testLevels(int level, int health) {
        setLevel(level);
        runGame();
        assertEquals(playerHealth(), health);
    }
}
