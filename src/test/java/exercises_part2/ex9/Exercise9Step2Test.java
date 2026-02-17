package exercises_part2.ex9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise9Step2Test {
    @Test
    void shouldDecorateText() {
        Exercise9Step2.TextComponent text = new Exercise9Step2.SimpleText("Ciao");
        
        // Creo classe anonima per testare l'astrazione
        Exercise9Step2.TextDecorator decorator = new Exercise9Step2.TextDecorator(text) {
            @Override public String read() { return super.read(); }
        };

        // FALLISCE (RED): read() ritorna stringa vuota
        assertEquals("Ciao", decorator.read());
    }
}