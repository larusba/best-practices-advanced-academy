package exercises_part2.ex10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise10Step4Test {
    @Test
    void shouldCreatePlane() {
        Exercise10Step4.Logistics airLogistics = new Exercise10Step4.AirLogistics();
        Exercise10Step4.Transport t = airLogistics.createTransport();
        
        // FALLISCE (RED): ritorna null
        assertTrue(t instanceof Exercise10Step4.Plane);
    }
}