package exercises_part2.ex1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise1Step3Test {
    @Test
    void shouldRegisterUser_delegatingToRepo() {
        Exercise1Step3.UserRepository mockRepo = mock(Exercise1Step3.UserRepository.class);
        Exercise1Step3.UserService service = new Exercise1Step3.UserService(mockRepo);

        service.register("test@test.com");

        // PASSA (GREEN)
        verify(mockRepo).save("test@test.com");
    }
}