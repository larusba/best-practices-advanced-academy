package intro.di;

public class MainAfter {
    interface IComputer {
        void boot();
    }

    static class ComputerLinux implements IComputer {
        public void boot() {
            System.out.println("Booting the linux computer...");
        }
    }

    /** This way, we can use different implementations of IComputer without change this code */
    static class User {
        public void startComputer(IComputer computer) {
            computer.boot();
        }
    }

    /** For example, by adding another IComputer implementation */
    static class ComputerWindows implements IComputer {
        public void boot() {
            System.out.println("Booting the win computer...");
        }
    }

    static class GFG {
        public static void main(String[] args) {
            User user = new User();
            IComputer computerLinux = new ComputerLinux();
            user.startComputer(computerLinux);

            // For example: I can add other IComputer implementations
            IComputer computerWindows = new ComputerWindows();
            user.startComputer(computerWindows);
        }
    }
}
