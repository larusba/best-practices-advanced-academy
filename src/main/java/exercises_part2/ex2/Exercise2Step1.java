package exercises_part2.ex2;

/**
 * STEP 1: CODICE LEGACY
 *
 * OBIETTIVI REFACTORING:
 * 1. Migliorare la leggibilità della creazione dell'oggetto (rimuovere costruttore telescopico).
 * 2. Gestire valori di default in modo trasparente.
 *
 * FEATURE FUTURA:
 * - Aggiungere un campo opzionale "Token" per l'autenticazione.
 */
public class Exercise2Step1 {
    public static class HttpRequest {
        String url;
        String method;
        int timeout;
        boolean async;

        public HttpRequest(String url, String method, int timeout, boolean async) {
            this.url = url;
            this.method = method;
            this.timeout = timeout;
            this.async = async;
        }
    }
}