package exercises_part2.ex9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise9Step3Test {
    @Test
    void shouldWrapWithBold() {
        Exercise9Step3.TextComponent text = new Exercise9Step3.SimpleText("Ciao");
        Exercise9Step3.TextComponent boldText = new Exercise9Step3.Bold(text);

        // PASSA (GREEN)
        assertEquals("<b>Ciao</b>", boldText.read());
    }
}