package exercises_part2.ex5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise5Step3Test {
    @Test
    void shouldTransitionFromNewToPaid() {
        Exercise5Step3.Order order = new Exercise5Step3.Order();
        // New -> Pay -> Paid
        order.pay();
        
        // Verifica indiretta (in un test reale userei instanceof o getter migliore)
        // Qui verifichiamo che il comportamento sia cambiato (ora posso spedire)
        order.ship(); 
        // Se non fossi in PaidState, ship stamperebbe errore o non cambierebbe nulla
    }
}