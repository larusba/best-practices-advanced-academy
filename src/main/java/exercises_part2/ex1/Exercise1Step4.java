package exercises_part2.ex1;

/**
 * FEATURE:
 * - Impedire la registrazione di email provenienti dal dominio "spam.com".
 */
public class Exercise1Step4 {
    public interface UserRepository {
        void save(String email);
    }

    public static class UserService {
        private UserRepository repository;

        public UserService(UserRepository repository) {
            this.repository = repository;
        }

        public void register(String email) {
            if (!email.contains("@")) throw new IllegalArgumentException("Email non valida");
            repository.save(email);
        }
    }
}