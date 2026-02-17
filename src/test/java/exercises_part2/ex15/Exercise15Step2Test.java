package exercises_part2.ex15;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise15Step2Test {
    @Test
    void shouldNotifyObservers() {
        Exercise15Step2.StockMarket market = new Exercise15Step2.StockMarket();
        Exercise15Step2.Observer obs = mock(Exercise15Step2.Observer.class);
        
        market.attach(obs);
        market.setPrice(100.0);

        // FALLISCE (RED)
        verify(obs).update(100.0);
    }
}