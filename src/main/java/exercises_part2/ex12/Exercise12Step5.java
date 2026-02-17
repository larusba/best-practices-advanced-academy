package exercises_part2.ex12;

public class Exercise12Step5 {
    public interface Image { void display(); }
    static class RealImage implements Image { public void display() {} }

    public static class SecureProxy implements Image {
        private RealImage real;
        private String userRole;

        public SecureProxy(String role) { this.userRole = role; }

        @Override
        public void display() {
            if (!"ADMIN".equals(userRole)) {
                throw new SecurityException("Access Denied");
            }
            if (real == null) real = new RealImage();
            real.display();
        }
    }
}