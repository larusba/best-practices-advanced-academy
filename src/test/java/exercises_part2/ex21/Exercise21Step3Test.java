package exercises_part2.ex21;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise21Step3Test {
    @Test
    void shouldExportToHtml() {
        Exercise21Step3.Element p = new Exercise21Step3.Paragraph("Hello");
        Exercise21Step3.Visitor htmlVisitor = new Exercise21Step3.HtmlExportVisitor();
        
        String result = p.accept(htmlVisitor);
        
        // PASSA (GREEN)
        assertEquals("<p>Hello</p>", result);
    }
}