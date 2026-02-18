package exercises_part2.ex12;

/**
 * FEATURE:
 * - Implementare un controllo: solo gli utenti "ADMIN" possono visualizzare l'immagine.
 */
public class Exercise12Step4 {
    public interface Image {
        void display();
    }

    public static class SecureProxy implements Image {
        private String userRole;

        public SecureProxy(String role) {
            this.userRole = role;
        }

        public void display() {
            // TODO: Controllare ruolo
        }
    }
}