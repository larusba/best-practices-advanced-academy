package exercises_part2.ex11;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise11Step4Test {
    @Test
    void shouldSupportModernApi() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Exercise11Step4.PaymentProcessor modern = new Exercise11Step4.ModernPaymentAdapter();
        modern.pay(99.0);

        // FALLISCE (RED)
        assertTrue(out.toString().contains("Modern API: 99.0"));
    }
}