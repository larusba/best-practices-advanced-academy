package exercises_part2.ex15;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise15Step3Test {
    @Test
    void shouldNotifyObservers() {
        Exercise15Step3.StockMarket market = new Exercise15Step3.StockMarket();
        Exercise15Step3.Observer obs = mock(Exercise15Step3.Observer.class);
        
        market.attach(obs);
        market.setPrice(100.0);

        // PASSA (GREEN)
        verify(obs).update(100.0);
    }
}