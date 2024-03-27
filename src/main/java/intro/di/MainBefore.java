package intro.di;

public class MainBefore {
    static class Computer {
        public void boot() {
            System.out.println("Booting the computer...");
        }
    }

    /** Violates the DI principle If there was some change in the `Computer` class */
    static class User {
        public void startComputer() {
            Computer computer = new Computer();
            computer.boot();
        }
    }

    static class GFG {
        public static void main(String[] args) {
            User user = new User();
            user.startComputer();
        }
    }
}
