package exercises_part2.ex8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise8Step2Test {
    @Test
    void shouldCalculateTotalRecursively() {
        Exercise8Step2.Menu menu = new Exercise8Step2.Menu();
        menu.add(new Exercise8Step2.Product(10.0));
        menu.add(new Exercise8Step2.Product(5.0));

        // FALLISCE (RED): getPrice ritorna 0
        assertEquals(15.0, menu.getPrice());
    }
}