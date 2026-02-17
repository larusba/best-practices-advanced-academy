package exercises_part2.ex1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise1Step2Test {
    @Test
    void shouldRegisterUser_delegatingToRepo() {
        // ARRANGE
        Exercise1Step2.UserRepository mockRepo = mock(Exercise1Step2.UserRepository.class);
        Exercise1Step2.UserService service = new Exercise1Step2.UserService(mockRepo);

        // ACT
        service.register("test@test.com");

        // ASSERT (RED: Fallisce perché il metodo è vuoto)
        verify(mockRepo).save("test@test.com");
    }
}