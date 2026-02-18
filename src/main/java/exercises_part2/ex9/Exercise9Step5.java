package exercises_part2.ex9;

public class Exercise9Step5 {
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

    // Implementazione Reale
    public static class Censor extends TextDecorator {
        public Censor(TextComponent w) {
            super(w);
        }

        @Override
        public String read() {
            String content = super.read();
            return content.replace("stupid", "***");
        }
    }
}