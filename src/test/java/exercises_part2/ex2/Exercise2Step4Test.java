package exercises_part2.ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise2Step4Test {
    @Test
    void shouldIncludeAuthToken() {
        Exercise2Step4.HttpRequest request = Exercise2Step4.HttpRequest.builder()
                .token("ABC")
                .build();
                
        // FALLISCE (RED): Il token non viene ancora salvato
        assertEquals("ABC", request.getToken());
    }
}