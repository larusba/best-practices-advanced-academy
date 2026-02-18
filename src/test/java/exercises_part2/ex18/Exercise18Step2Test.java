package exercises_part2.ex18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Exercise18Step2Test {
    @Test
    void shouldSaveState() {
        Exercise18Step2.Editor editor = new Exercise18Step2.Editor();
        editor.setContent("Test");
        
        // FALLISCE (RED)
        assertNotNull(editor.save());
    }
}