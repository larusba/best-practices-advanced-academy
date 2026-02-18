package exercises_part2.ex21;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise21Step5Test {
    @Test
    void shouldExportToXml() {
        Exercise21Step3.Image img = new Exercise21Step3.Image("photo.jpg");
        Exercise21Step5.XmlExportVisitor xmlVisitor = new Exercise21Step5.XmlExportVisitor();
        
        // PASSA (GREEN)
        assertEquals("<media>photo.jpg</media>", img.accept(xmlVisitor));
    }
}