package exercises_part2.ex11;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise11Step3Test {
    @Test
    void adapterShouldCallLegacyCode() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Exercise11Step3.PaymentProcessor adapter = new Exercise11Step3.LegacyBankAdapter();
        adapter.pay(50.0);

        // PASSA (GREEN)
        assertTrue(out.toString().contains("Legacy: 50.0"));
    }
}