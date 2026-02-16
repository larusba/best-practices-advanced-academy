package exercises;

/**
 * Classe iniziale,
 * giusto per avere un metodo "richiamabile" dal TDD
 */
public class StringCalculator {

    public static final String NEGATIVI_NON_AMMESSI = "Negativi non ammessi";

    public int add(String numbers) {
        if (numbers.equals("")) {
            return 0;
        }
        String[] parts = numbers.split(",|\n");
        int sum = 0;

        for (String part : parts) {
            int num = Integer.parseInt(part);

            // Edge case: ignorare numeri grandi
            if (num > 1000) {
                continue;
            }

            // Edge case: numeri negativi non ammessi
            if (num < 0) {
                throw new IllegalArgumentException(NEGATIVI_NON_AMMESSI);
            }

            sum += num;
        }
        return sum;
    }
}
