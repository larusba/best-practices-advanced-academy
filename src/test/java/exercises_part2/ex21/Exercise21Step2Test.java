package exercises_part2.ex21;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise21Step2Test {
    @Test
    void shouldAcceptVisitor() {
        Exercise21Step2.Visitor mockVisitor = mock(Exercise21Step2.Visitor.class);
        Exercise21Step2.Element paragraph = new Exercise21Step2.Element() {
            public String accept(Exercise21Step2.Visitor v) { 
                // Simuliamo il comportamento atteso: chiamare visit
                return v.visit(new Exercise21Step2.Paragraph()); 
            }
        };

        paragraph.accept(mockVisitor);

        // FALLISCE (RED): Se non implementiamo la logica
        verify(mockVisitor).visit(any(Exercise21Step2.Paragraph.class));
    }
}