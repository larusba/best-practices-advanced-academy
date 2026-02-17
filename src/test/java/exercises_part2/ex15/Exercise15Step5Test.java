package exercises_part2.ex15;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise15Step5Test {
    @Test
    void shouldNotNotifyIfChangeIsSmall() {
        Exercise15Step5.StockMarket market = new Exercise15Step5.StockMarket();
        Exercise15Step5.Observer obs = mock(Exercise15Step5.Observer.class);
        
        market.attach(obs);
        market.setPrice(100.0); // 100% change -> notify
        market.setPrice(101.0); // 1% change -> ignore

        // PASSA (GREEN): Notificato solo la prima volta
        verify(obs, times(1)).update(100.0);
        verify(obs, never()).update(101.0);
    }
}