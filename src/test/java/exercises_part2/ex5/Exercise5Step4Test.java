package exercises_part2.ex5;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise5Step4Test {
    @Test
    void shouldTransitionToRefunded() {
        Exercise5Step4.Order order = new Exercise5Step4.Order();
        Exercise5Step4.OrderState mockState = mock(Exercise5Step4.OrderState.class);
        order.setState(mockState);
        
        order.refund();
        
        // FALLISCE (RED): Il metodo refund dell'ordine è vuoto
        verify(mockState).refund(order);
    }
}