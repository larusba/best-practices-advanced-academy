package exercises_part2.ex5;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise5Step2Test {
    @Test
    void shouldDelegateToState() {
        Exercise5Step2.Order order = new Exercise5Step2.Order();
        Exercise5Step2.OrderState mockState = mock(Exercise5Step2.OrderState.class);
        
        order.setState(mockState);
        order.pay();

        // FALLISCE (RED): Il metodo pay() è vuoto
        verify(mockState).pay(order);
    }
}