package exercises_part2.ex2;

/**
 * STEP 2: DESIGN DEL BUILDER (RED)
 *
 * OBIETTIVO REFACTORING:
 * Applicare il **BUILDER PATTERN**.
 *
 * 1. Creare una classe statica `Builder` interna.
 * 2. Rendere il costruttore di `HttpRequest` privato.
 * 3. Definire un'API fluente (`.url().timeout()`) per la costruzione.
 */
public class Exercise2Step2 {
    public static class HttpRequest {
        private String url;

        public static Builder builder() { return new Builder(); }

        public static class Builder {
            // Metodi Stub per permettere la compilazione del test
            public Builder url(String u) { return this; }
            public Builder timeout(int t) { return this; }
            public HttpRequest build() { return new HttpRequest(); } // Ritorna oggetto vuoto
        }

        public String getUrl() { return url; }
    }
}