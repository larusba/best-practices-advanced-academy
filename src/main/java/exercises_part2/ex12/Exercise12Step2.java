package exercises_part2.ex12;

/**
 * STEP 2: DESIGN DEL PROXY (RED)
 * 
 * OBIETTIVO:
 * Creare un'interfaccia comune `Image`.
 * Creare un `ImageProxy` che gestisca l'istanza reale solo quando serve.
 */
public class Exercise12Step2 {

    public interface Image {
        void display();
    }

    public static class ImageProxy implements Image {
        // Stub
        public void display() {
            // TODO: Inizializzare RealImage solo qui
        }
    }
}