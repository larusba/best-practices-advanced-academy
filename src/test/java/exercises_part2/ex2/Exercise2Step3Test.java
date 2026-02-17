package exercises_part2.ex2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise2Step3Test {
    @Test
    void shouldBuildRequest() {
        Exercise2Step3.HttpRequest request = Exercise2Step3.HttpRequest.builder()
                .url("http://google.com")
                .timeout(2000)
                .build();
        
        // PASSA (GREEN)
        assertEquals("http://google.com", request.getUrl());
    }
}