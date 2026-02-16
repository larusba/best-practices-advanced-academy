package exercises;

/**
 * REFACTORING:
 * 1. **State Pattern**: Ogni stato è una classe che implementa l'interfaccia `State`.
 * 2. La classe `Document` (Context) delega il comportamento allo stato corrente.
 * 3. Le transizioni di stato sono gestite polimorficamente (niente più if-else giganti).
 */
public class Exercise15After {

    // Context
    public static class Document {
        private State state;
        private String content;

        public Document() {
            // Stato iniziale
            this.state = new DraftState();
        }

        public void setState(State state) {
            this.state = state;
        }

        public void publish() {
            state.publish(this);
        }

        public void edit(String newContent) {
            state.edit(this, newContent);
        }

        public void setContent(String content) { this.content = content; }
    }

    // State Interface
    interface State {
        void publish(Document doc);
        void edit(Document doc, String content);
    }

    // Concrete State: DRAFT
    public static class DraftState implements State {
        @Override
        public void publish(Document doc) {
            System.out.println("Draft -> Review.");
            doc.setState(new ReviewState());
        }

        @Override
        public void edit(Document doc, String content) {
            doc.setContent(content);
            System.out.println("Content updated in Draft.");
        }
    }

    // Concrete State: REVIEW
    public static class ReviewState implements State {
        @Override
        public void publish(Document doc) {
            System.out.println("Review -> Published.");
            doc.setState(new PublishedState());
        }

        @Override
        public void edit(Document doc, String content) {
            System.out.println("Error: Cannot edit while in Review.");
        }
    }

    // Concrete State: PUBLISHED
    public static class PublishedState implements State {
        @Override
        public void publish(Document doc) {
            System.out.println("Error: Already published.");
        }

        @Override
        public void edit(Document doc, String content) {
            System.out.println("Error: Cannot edit published document.");
        }
    }

    public static void main(String[] args) {
        Document doc = new Document();
        doc.edit("Hello World"); // OK
        doc.publish();           // Va in Review
        doc.edit("Change");      // Errore
        doc.publish();           // Va in Published
    }
}