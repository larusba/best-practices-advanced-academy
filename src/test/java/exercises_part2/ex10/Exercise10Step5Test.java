package exercises_part2.ex10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise10Step5Test {
    @Test
    void shouldCreatePlane() {
        Exercise10Step5.Logistics airLogistics = new Exercise10Step5.AirLogistics();
        Exercise10Step5.Transport t = airLogistics.createTransport();
        
        // PASSA (GREEN)
        assertTrue(t instanceof Exercise10Step5.Plane);
    }
}