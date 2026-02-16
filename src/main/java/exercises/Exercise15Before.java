package exercises;

/**
 * ESERCIZIO COMPLESSO:
 * Gestione di una macchina a stati tramite stringhe e if-else annidati.
 * 1. Se aggiungi uno stato "ARCHIVED", devi modificare tutti i metodi (Open/Closed violation).
 * 2. La logica di transizione è duplicata e fragile.
 */
public class Exercise15Before {

    public static class Document {
        private String state = "DRAFT"; // Primitive Obsession
        private String content;

        public void publish() {
            if (state.equals("DRAFT")) {
                state = "REVIEW";
                System.out.println("Sent to review.");
            } else if (state.equals("REVIEW")) {
                state = "PUBLISHED";
                System.out.println("Document published.");
            } else if (state.equals("PUBLISHED")) {
                System.out.println("Already published.");
            }
        }

        public void edit(String newContent) {
            if (state.equals("DRAFT")) {
                this.content = newContent;
                System.out.println("Content updated.");
            } else {
                System.out.println("Cannot edit in " + state);
            }
        }
    }
}


