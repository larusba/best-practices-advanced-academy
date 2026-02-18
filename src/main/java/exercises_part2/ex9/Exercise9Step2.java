package exercises_part2.ex9;

/**
 * STEP 2: DESIGN DECORATOR (RED)
 * Obiettivo: "Avvolgere" oggetti uno dentro l'altro.
 */
public class Exercise9Step2 {

    public interface TextComponent {
        String read();
    }

    public static class SimpleText implements TextComponent {
        private String text;

        public SimpleText(String t) {
            this.text = t;
        }

        public String read() {
            return text;
        }
    }

    // Decoratore Base
    public static abstract class TextDecorator implements TextComponent {
        protected TextComponent wrapped;

        public TextDecorator(TextComponent w) {
            this.wrapped = w;
        }

        public String read() {
            return ""; /* TODO: Delegare */
        }
    }
}