package exercises_part2.ex6;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Catena di IF rigida:** Per aggiungere un nuovo livello di gestione, bisogna modificare il metodo centrale.
 * 2. **Difficoltà di configurazione:** Non posso cambiare dinamicamente l'ordine di gestione.
 *
 * FEATURE FUTURA:
 * - Aggiungere un filtro "SpamFilter" che blocca certi messaggi prima che vengano loggati.
 */
public class Exercise6Step1 {
    public static class Logger {
        public void log(String level, String msg) {
            if (level.equals("INFO")) {
                System.out.println("[INFO] " + msg);
            } else if (level.equals("ERROR")) {
                System.err.println("[ERROR] " + msg);
                System.out.println("Sending email to admin...");
            } else {
                System.out.println("Log ignorato: " + msg);
            }
        }
    }
}