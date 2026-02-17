package exercises_part2.ex4;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise4Step4Test {
    @Test
    void shouldPayWithBitcoin() {
        // Catturo System.out per verificare la stampa (in un caso reale verificherei chiamate API)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Exercise4Step4.PaymentProcessor processor = new Exercise4Step4.PaymentProcessor();
        processor.process(new Exercise4Step4.BitcoinPayment(), 0.5);

        // FALLISCE (RED): L'implementazione è vuota
        assertTrue(outContent.toString().contains("Pagamento Crypto: 0.5"));
    }
}