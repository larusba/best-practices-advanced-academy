package exercises_part2.ex18;

/**
 * STEP 2: DESIGN MEMENTO (RED)
 *
 * OBIETTIVO:
 * Creare un oggetto `Memento` opaco che contenga lo stato.
 * L'editor sa creare un Memento e ripristinarsi da esso.
 */
public class Exercise18Step2 {
    public static class Memento {
        private String state;
        public Memento(String state) { this.state = state; }
        public String getState() { return state; }
    }

    public static class Editor {
        private String content;
        
        public void setContent(String c) { this.content = c; }
        
        // Stub
        public Memento save() { return null; }
        public void restore(Memento m) {}
    }
}