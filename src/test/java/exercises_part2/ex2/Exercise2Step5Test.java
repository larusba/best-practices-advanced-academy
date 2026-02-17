package exercises_part2.ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise2Step5Test {
    @Test
    void shouldIncludeAuthToken() {
        Exercise2Step5.HttpRequest request = Exercise2Step5.HttpRequest.builder()
                .token("ABC")
                .build();
        // PASSA (GREEN)
        assertEquals("ABC", request.getToken());
    }
}