package exercises_part2.ex12;

/**
 * STEP 1: CODICE LEGACY
 * 
 * ANALISI CODE SMELL:
 * 1. **Performance:** L'immagine viene caricata dal disco appena viene istanziata,
 * anche se magari non verrà mai visualizzata.
 * 
 * FEATURE FUTURA:
 * - Implementare un controllo: solo gli utenti "ADMIN" possono visualizzare l'immagine.
 */
public class Exercise12Step1 {
    public static class HighResImage {
        public HighResImage(String filename) {
            loadFromDisk(filename); // Operazione pesante!
        }

        private void loadFromDisk(String filename) {
            System.out.println("Loading " + filename);
        }

        public void display() {
            System.out.println("Displaying image");
        }
    }
}