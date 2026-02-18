package exercises_part2.ex22;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise22Step2Test {
    @Test
    void shouldConnectUsingInjectedConfig() {
        Exercise22Step2.ConfigProvider mockConfig = mock(Exercise22Step2.ConfigProvider.class);
        when(mockConfig.getDbUrl()).thenReturn("jdbc:test");

        Exercise22Step2.DatabaseService service = new Exercise22Step2.DatabaseService(mockConfig);
        service.connect();

        // FALLISCE (RED): connect() è vuoto
        verify(mockConfig).getDbUrl();
    }
}