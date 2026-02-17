package exercises_part2.ex1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise1Step5Test {
    @Test
    void shouldBlockSpamDomains() {
        Exercise1Step5.UserRepository mockRepo = mock(Exercise1Step5.UserRepository.class);
        Exercise1Step5.UserService service = new Exercise1Step5.UserService(mockRepo);

        // PASSA (GREEN)
        assertThrows(IllegalArgumentException.class, () -> 
            service.register("hacker@spam.com")
        );
    }
}