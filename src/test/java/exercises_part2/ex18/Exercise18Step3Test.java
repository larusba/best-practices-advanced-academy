package exercises_part2.ex18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise18Step3Test {
    @Test
    void shouldRestoreState() {
        Exercise18Step3.Editor editor = new Exercise18Step3.Editor();
        editor.setContent("Version 1");
        Exercise18Step3.Memento saved = editor.save();
        
        editor.setContent("Version 2");
        editor.restore(saved);

        // PASSA (GREEN)
        assertEquals("Version 1", editor.getContent());
    }
}