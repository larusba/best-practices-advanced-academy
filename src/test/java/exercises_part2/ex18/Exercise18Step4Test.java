package exercises_part2.ex18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Exercise18Step4Test {
    @Test
    void shouldManageHistory() {
        Exercise18Step4.History history = new Exercise18Step4.History();
        history.push(new Exercise18Step3.Memento("State"));
        
        // FALLISCE (RED)
        assertNotNull(history.pop());
    }
}