package exercises_part2.ex5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise5Step5Test {
    @Test
    void shouldTransitionToRefunded() {
        Exercise5Step5.Order order = new Exercise5Step5.Order();
        order.setState(new Exercise5Step5.PaidState());
        
        order.refund();
        
        assertTrue(order.getState() instanceof Exercise5Step5.RefundedState);
    }
}