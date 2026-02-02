package designpattern.flyweight;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Esempio del Design Pattern Flyweight.
 *
 * Il Flyweight viene utilizzato per minimizzare l'uso della memoria condividendo
 * il più possibile dati con oggetti simili. È essenziale quando si devono gestire
 * grandi quantità di oggetti (es. caratteri in un editor di testo) che condividono
 * molte proprietà ripetitive (es. font, colore, dimensione).
 *
 * Concetti chiave:
 * - Stato Intrinseco: Dati condivisi e immutabili (memorizzati nel Flyweight).
 * - Stato Estrinseco: Dati specifici del contesto (passati dall'esterno, non salvati qui).
 */
public class Main {
    public enum Color {
        RED,
        GREEN,
        BLUE
    }

    public enum FontEffect {
        BOLD,
        ITALIC,
        SUPERSCRIPT,
        SUBSCRIPT,
        STRIKETHROUGH
    }

    /**
     * Classe Flyweight Concreta.
     * Rappresenta lo "Stato Intrinseco" (Intrinsic State) della formattazione del testo.
     *
     * CARATTERISTICA CRUCIALE: IMMUTABILITÀ.
     * Poiché questi oggetti sono condivisi tra molte parti dell'applicazione,
     * non devono assolutamente poter cambiare stato una volta creati, altrimenti
     * la modifica si rifletterebbe ovunque quell'oggetto è usato.
     */
    public static final class FontData {
        /**
         * Il "Pool" o Cache dei Flyweight.
         * Garantisce che esista una sola istanza per ogni combinazione unica di proprietà.
         * In implementazioni più complesse, questa cache starebbe in una classe "FlyweightFactory".
         */
        private static final Set<FontData> flyweightData = new HashSet<>();
        
        private final int pointSize;
        private final String fontFace;
        private final Color color;
        private final Set<FontEffect> effects;

        private FontData(int pointSize, String fontFace, Color color, EnumSet<FontEffect> effects) {
            this.pointSize = pointSize;
            this.fontFace = fontFace;
            this.color = color;
            this.effects = Collections.unmodifiableSet(effects);
        }

        /**
         * Factory Method (Flyweight Factory).
         * * Questo è il punto centrale del pattern. Invece di usare 'new' liberamente:
         * 1. Costruisce un candidato oggetto.
         * 2. Controlla nella cache se esiste già un oggetto identico (tramite equals).
         * 3. Se esiste, restituisce il riferimento all'oggetto già in memoria.
         * 4. Se non esiste, lo aggiunge alla cache e lo restituisce.
         *
         * Risultato: Se il documento ha 10.000 parole in "Arial 12 Rosso",
         * in memoria avremo 1 solo oggetto FontData, non 10.000.
         *
         * @return L'istanza univoca (condivisa) per questi dati.
         */
        public static FontData create(
                int pointSize, String fontFace, Color color, FontEffect... effects) {
            EnumSet<FontEffect> effectsSet = EnumSet.noneOf(FontEffect.class);
            effectsSet.addAll(Arrays.asList(effects));
            
            // Creiamo un oggetto temporaneo solo per verificare se esiste nella cache
            FontData data = new FontData(pointSize, fontFace, color, effectsSet);
            
            // Tentiamo di aggiungere: se esiste già, non fa nulla (grazie a equals/hashCode)
            flyweightData.add(data);
            
            // Recuperiamo l'istanza "canonica" presente nel set.
            // Nota: Set non ha un metodo 'get', quindi usiamo lo stream per trovare
            // l'oggetto che è equals() al nostro dato temporaneo.
            return flyweightData.stream().filter(data::equals).findFirst().get();
        }

        /**
         * Equals e HashCode sono FONDAMENTALI nel Flyweight.
         * Servono alla cache (HashSet) per identificare se un oggetto con
         * le stesse proprietà esiste già, evitando duplicati.
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            FontData other = (FontData) obj;
            if (color == null) {
                if (other.color != null) return false;
            } else if (!color.equals(other.color)) return false;
            if (effects == null) {
                if (other.effects != null) return false;
            } else if (!effects.equals(other.effects)) return false;
            if (fontFace == null) {
                if (other.fontFace != null) return false;
            } else if (!fontFace.equals(other.fontFace)) return false;
            if (pointSize != other.pointSize) return false;
            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((color == null) ? 0 : color.hashCode());
            result = prime * result + ((effects == null) ? 0 : effects.hashCode());
            result = prime * result + ((fontFace == null) ? 0 : fontFace.hashCode());
            result = prime * result + pointSize;
            return result;
        }

        // Getters for the font data, but no setters. FontData is immutable.
    }
}