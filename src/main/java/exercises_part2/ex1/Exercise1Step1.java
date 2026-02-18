package exercises_part2.ex1;

/**
 * STEP 1: CODICE LEGACY
 * 
 * OBIETTIVI REFACTORING:
 * 1. Separare la logica di business dall'accesso ai dati (DB).
 * 2. Rendere la logica testabile eliminando le dipendenze statiche.
 * 
 * FEATURE FUTURA:
 * - Impedire la registrazione di email provenienti dal dominio "spam.com".
 */
public class Exercise1Step1 {
    public static class UserController {
        public void registerUser(String email) {
            // Validazione
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Email non valida");
            }

            // Logica + DB (Hard Dependency)
            System.out.println("Salvataggio...");
            Database.execute("INSERT INTO users VALUES ('" + email + "')");
        }
    }

    static class Database {
        public static void execute(String sql) {
            System.out.println("DB EXEC: " + sql);
        }
    }
}