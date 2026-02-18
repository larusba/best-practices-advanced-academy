package exercises_part2.ex18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Exercise18Step5Test {
    @Test
    void shouldManageHistory() {
        Exercise18Step5.History history = new Exercise18Step5.History();
        history.push(new Exercise18Step3.Memento("State"));
        
        // PASSA (GREEN)
        assertNotNull(history.pop());
    }
}