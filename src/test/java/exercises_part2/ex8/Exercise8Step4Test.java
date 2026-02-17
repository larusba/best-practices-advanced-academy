package exercises_part2.ex8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise8Step4Test {
    @Test
    void shouldApplyDiscountToChildren() {
        Exercise8Step4.DiscountMenu menu = new Exercise8Step4.DiscountMenu();
        menu.add(new Exercise8Step4.Product(100.0));
        
        // Mi aspetto il 10% di sconto -> 90.0
        // FALLISCE (RED): ritorna 0
        assertEquals(90.0, menu.getPrice());
    }
}