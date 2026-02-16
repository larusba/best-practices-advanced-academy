package exercises;

/**
 * ESERCIZIO: Rifattorizza questo metodo per migliorarne la leggibilità.
 */
public class Exercise9Before {

    public double calculate(double amount, int type, int years) {
        double result = amount;
        // Cosa significano 1, 2, 3? E 0.90, 0.85?
        if (type == 1) {
            result = amount * 0.90;
        } else if (type == 2) {
            result = amount * 0.85;
        } else if (type == 3) {
            result = amount * 0.70;
        }

        // Condizione difficile da decifrare a colpo d'occhio
        if (years > 5 && (type == 2 || type == 3)) {
            result = result - 5;
        }

        return result;
    }
}