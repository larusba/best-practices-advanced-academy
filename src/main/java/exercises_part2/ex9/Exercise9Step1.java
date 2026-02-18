package exercises_part2.ex9;

/**
 * STEP 1: CODICE LEGACY
 * 
 * ANALISI CODE SMELL:
 * 1. **Class Explosion:** Per ogni combinazione di formattazione creiamo una nuova classe (BoldItalicText, UnderlinedBoldText...).
 * 2. **Ereditarietà Statica:** Non posso aggiungere/rimuovere formattazioni a runtime.
 * 
 * FEATURE FUTURA:
 * - Aggiungere un filtro "Censore" che sostituisce "stupid" con "***".
 */
public class Exercise9Step1 {
    public static class Text {
        public String getContent() {
            return "hello";
        }
    }

    public static class BoldText extends Text {
        @Override
        public String getContent() {
            return "<b>" + super.getContent() + "</b>";
        }
    }

    public static class ItalicText extends Text {
        @Override
        public String getContent() {
            return "<i>" + super.getContent() + "</i>";
        }
    }

    // Combinazione manuale... insostenibile!
    public static class BoldItalicText extends Text {
        @Override
        public String getContent() {
            return "<b><i>" + super.getContent() + "</i></b>";
        }
    }
}