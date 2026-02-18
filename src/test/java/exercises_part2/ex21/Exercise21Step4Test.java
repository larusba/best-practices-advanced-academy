package exercises_part2.ex21;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise21Step4Test {
    @Test
    void shouldExportToXml() {
        Exercise21Step3.Paragraph p = new Exercise21Step3.Paragraph("Data");
        Exercise21Step4.XmlExportVisitor xmlVisitor = new Exercise21Step4.XmlExportVisitor();
        
        String result = p.accept(xmlVisitor);
        
        // FALLISCE (RED): Ritorna stringa vuota
        assertEquals("<text>Data</text>", result);
    }
}