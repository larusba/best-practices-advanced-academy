package exercises_part2.ex1;

/**
 * STEP 2: DESIGN DELL'ARCHITETTURA (RED)
 * 
 * OBIETTIVO REFACTORING:
 * Applicare la **DEPENDENCY INJECTION** e la **LAYERED ARCHITECTURE**.
 * * PIANO D'AZIONE:
 * 1. Creare un'interfaccia `UserRepository` per astrarre l'accesso ai dati.
 * 2. Creare una classe `UserService` per contenere la logica di business pura.
 * 3. Iniettare il Repository nel Service tramite costruttore.
 * 
 * NOTA:
 * I metodi sono vuoti (Stub) per permettere la compilazione del test, ma il test fallirà.
 */
public class Exercise1Step2 {

    // 1. Interfaccia (Port)
    public interface UserRepository {
        void save(String email);
    }

    // 2. Service (Business Logic)
    public static class UserService {
        private UserRepository repository;

        public UserService(UserRepository repository) {
            this.repository = repository;
        }

        public void register(String email) {
            // TODO: Implementare la logica
        }
    }
}