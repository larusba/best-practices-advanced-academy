package exercises_part2.ex4;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise4Step5Test {
    @Test
    void shouldPayWithBitcoin() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exercise4Step5.PaymentProcessor processor = new Exercise4Step5.PaymentProcessor();
        processor.process(new Exercise4Step5.BitcoinPayment(), 0.5);

        // PASSA (GREEN)
        assertTrue(outContent.toString().contains("Pagamento Crypto: 0.5"));
    }
}