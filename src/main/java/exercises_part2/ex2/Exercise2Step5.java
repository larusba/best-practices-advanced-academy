package exercises_part2.ex2;

public class Exercise2Step5 {
    public static class HttpRequest {
        private String token;

        private HttpRequest(Builder b) {
            this.token = b.token;
        }

        public String getToken() {
            return token;
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private String token;

            // Implementazione Reale
            public Builder token(String t) {
                this.token = t;
                return this;
            }

            public HttpRequest build() {
                return new HttpRequest(this);
            }
        }
    }
}