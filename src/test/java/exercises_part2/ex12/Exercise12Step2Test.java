package exercises_part2.ex12;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise12Step2Test {
    @Test
    void shouldDelegateToRealImageOnDisplay() {
        // Per testare il proxy, usiamo un approccio white-box o simulato.
        // Qui verifichiamo che display() faccia qualcosa (nel refactoring mockiamo la RealImage).
        Exercise12Step2.ImageProxy proxy = new Exercise12Step2.ImageProxy();
        
        // Questo test fallisce concettualmente perché display è vuoto e non carica nulla
        proxy.display();
    }
}