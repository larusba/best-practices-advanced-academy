package exercises_part2.ex8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise8Step3Test {
    @Test
    void shouldCalculateTotalRecursively() {
        Exercise8Step3.Menu menu = new Exercise8Step3.Menu();
        menu.add(new Exercise8Step3.Product(10.0));
        menu.add(new Exercise8Step3.Product(5.0));

        // PASSA (GREEN)
        assertEquals(15.0, menu.getPrice());
    }
}