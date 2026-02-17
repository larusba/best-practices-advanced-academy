package exercises_part2.ex1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise1Step4Test {
    @Test
    void shouldBlockSpamDomains() {
        Exercise1Step4.UserRepository mockRepo = mock(Exercise1Step4.UserRepository.class);
        Exercise1Step4.UserService service = new Exercise1Step4.UserService(mockRepo);

        // FALLISCE (RED): Il codice attuale accetta spam.com
        assertThrows(IllegalArgumentException.class, () -> 
            service.register("hacker@spam.com")
        );
    }
}