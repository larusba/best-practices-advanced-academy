package exercises_part2.ex2;

/**
 * REFACTORING COMPLETATO (GREEN)
 * Il Builder ora funziona correttamente e assegna i valori all'oggetto HttpRequest.
 * 
 * FEATURE:
 * - Aggiungere un campo opzionale "Token" per l'autenticazione.
 */
public class Exercise2Step3 {
    public static class HttpRequest {
        private String url;
        private int timeout;

        private HttpRequest(Builder b) {
            this.url = b.url;
            this.timeout = b.timeout;
        }

        public String getUrl() {
            return url;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private String url;
            private int timeout = 1000;

            public Builder url(String url) {
                this.url = url;
                return this;
            }

            public Builder timeout(int t) {
                this.timeout = t;
                return this;
            }

            public HttpRequest build() {
                return new HttpRequest(this);
            }
        }
    }
}