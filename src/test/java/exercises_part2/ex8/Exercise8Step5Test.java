package exercises_part2.ex8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise8Step5Test {
    @Test
    void shouldApplyDiscountToChildren() {
        Exercise8Step5.DiscountMenu menu = new Exercise8Step5.DiscountMenu();
        menu.add(new Exercise8Step5.Product(100.0));
        
        // PASSA (GREEN)
        assertEquals(90.0, menu.getPrice());
    }
}