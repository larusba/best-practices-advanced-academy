package exercises_part2.ex1;

public class Exercise1Step5 {
    public interface UserRepository {
        void save(String email);
    }

    public static class UserService {
        private UserRepository repository;

        public UserService(UserRepository repository) {
            this.repository = repository;
        }

        public void register(String email) {
            // === NUOVA LOGICA ===
            if (email.endsWith("@spam.com")) {
                throw new IllegalArgumentException("Dominio bannato");
            }

            if (!email.contains("@")) throw new IllegalArgumentException("Email non valida");
            repository.save(email);
        }
    }
}