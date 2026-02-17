package exercises_part2.ex15;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise15Step4Test {
    @Test
    void shouldNotNotifyIfChangeIsSmall() {
        Exercise15Step4.StockMarket market = new Exercise15Step4.StockMarket();
        Exercise15Step4.Observer obs = mock(Exercise15Step4.Observer.class);
        
        market.attach(obs);
        market.setPrice(100.0); // Primo prezzo
        market.setPrice(101.0); // Variazione 1% (< 5%)

        // FALLISCE (RED): Attualmente notifica sempre (2 volte)
        // Noi vogliamo che la seconda volta NON notifichi
        verify(obs, times(1)).update(anyDouble());
    }
}