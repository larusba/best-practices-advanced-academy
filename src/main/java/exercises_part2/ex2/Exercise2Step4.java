package exercises_part2.ex2;

public class Exercise2Step4 {
    public static class HttpRequest {
        private String token; // Campo nuovo
        public String getToken() { return token; }
        public static Builder builder() { return new Builder(); }

        public static class Builder {
            public Builder url(String u) { return this; }
            
            // Stub del nuovo metodo .token()
            public Builder token(String t) { return this; } 
            
            public HttpRequest build() { return new HttpRequest(); }
        }
    }
}