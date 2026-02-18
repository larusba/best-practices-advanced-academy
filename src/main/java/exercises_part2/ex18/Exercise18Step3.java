package exercises_part2.ex18;

public class Exercise18Step3 {
    public static class Memento {
        private final String state;
        public Memento(String state) { this.state = state; }
        public String getState() { return state; }
    }

    public static class Editor {
        private String content;
        public void setContent(String c) { this.content = c; }
        public String getContent() { return content; }

        public Memento save() { return new Memento(content); }
        public void restore(Memento m) { this.content = m.getState(); }
    }
}