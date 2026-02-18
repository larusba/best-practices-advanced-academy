package exercises_part2.ex9;

/**
 * FEATURE:
 * - Aggiungere un filtro "Censore" che sostituisce "stupid" con "***".
 */
public class Exercise9Step4 {
    public interface TextComponent {
        String read();
    }

    public static abstract class TextDecorator implements TextComponent {
        protected TextComponent wrapped;

        public TextDecorator(TextComponent w) {
            this.wrapped = w;
        }

        public String read() {
            return wrapped.read();
        }
    }

    // Stub
    public static class Censor extends TextDecorator {
        public Censor(TextComponent w) {
            super(w);
        }

        public String read() {
            // TODO: Implement logic
            return super.read();
        }
    }
}