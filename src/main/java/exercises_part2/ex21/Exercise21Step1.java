package exercises_part2.ex21;

import java.util.ArrayList;
import java.util.List;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Violazione SRP:** Le classi di dominio (`Paragraph`, `Image`) contengono logica di presentazione (`toHtml`, `toText`).
 * 2. **Rigidità:** Per aggiungere un nuovo formato (es. XML), devo modificare tutte le classi del dominio.
 *
 * FEATURE FUTURA:
 * - Aggiungere l'esportazione in XML senza toccare le classi Paragraph e Image.
 */
public class Exercise21Step1 {
    public interface DocumentElement {
        String export(String format);
    }

    public static class Paragraph implements DocumentElement {
        private String text;
        public Paragraph(String t) { this.text = t; }
        
        public String export(String format) {
            if (format.equals("html")) return "<p>" + text + "</p>";
            if (format.equals("text")) return text;
            return "";
        }
    }

    public static class Image implements DocumentElement {
        private String src;
        public Image(String s) { this.src = s; }
        
        public String export(String format) {
            if (format.equals("html")) return "<img src='" + src + "' />";
            if (format.equals("text")) return "[Image: " + src + "]";
            return "";
        }
    }
}