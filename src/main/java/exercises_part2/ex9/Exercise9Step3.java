package exercises_part2.ex9;

/**
 * STEP 3: REFACTORING COMPLETATO (GREEN)
 */
public class Exercise9Step3 {
    public interface TextComponent { String read(); }

    public static class SimpleText implements TextComponent {
        private String text;
        public SimpleText(String t) { this.text = t; }
        public String read() { return text; }
    }

    public static abstract class TextDecorator implements TextComponent {
        protected TextComponent wrapped;
        public TextDecorator(TextComponent w) { this.wrapped = w; }
        public String read() { return wrapped.read(); }
    }

    // Decoratori concreti
    public static class Bold extends TextDecorator {
        public Bold(TextComponent w) { super(w); }
        public String read() { return "<b>" + super.read() + "</b>"; }
    }
}