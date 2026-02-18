package exercises_part2.ex21;

/**
 * STEP 2: DESIGN VISITOR (RED)
 *
 * OBIETTIVO:
 * Creare un'interfaccia `Visitor` che visiti gli elementi.
 * Gli elementi devono accettare il visitatore (Double Dispatch).
 */
public class Exercise21Step2 {
    
    // Le classi dominio sono semplici contenitori dati
    public static class Paragraph { 
        public String getText() { return "text"; } 
    }
    public static class Image { 
        public String getSrc() { return "src"; } 
    }

    // Interfaccia del Visitatore
    public interface Visitor {
        String visit(Paragraph p);
        String visit(Image i);
    }

    // Interfaccia Elemento Visibile
    public interface Element {
        // Stub: Metodo per accettare il visitor
        String accept(Visitor v);
    }
}