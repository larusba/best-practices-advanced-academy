package intro.var_declaration;

import java.util.UUID;

public class Main {

    interface IComputer {
        void boot();
    }

    static class ComputerLinux implements IComputer {
        public void boot() {
            System.out.println("Booting the computer...");
        }

        public void startTerminal() {
            System.out.println("sudo destroy stuff");
        }
    }

    static class ComputerWindows implements IComputer {
        public void boot() {
            System.out.println("Booting the computer...");
        }

        public void playVideoGames() {
            System.out.println("Hadouken!!");
        }
    }

    static class ComputerMac implements IComputer {
        public void boot() {
            System.out.println("Booting the computer...");
        }

        public void openIntelliJ() {
            System.out.println("create sw..");
        }
    }

    static class User {
        public void startComputer(IComputer computer) {
            computer.boot();
        }
    }

    /** Assign to implementation */
    static class AppOne {
        public static void main(String[] args) {
            User user = new User();
            ComputerLinux computerLinux = new ComputerLinux();
            user.startComputer(computerLinux);

            // I use something specific of ComputerLinux
            computerLinux.startTerminal();
        }
    }

    /** Assign to interface */
    static class AppTwo {
        public static void main(String[] args) {
            User user = new User();

            IComputer computer = new ComputerLinux();
            user.startComputer(computer);

            // we could reassign variable to other implementation
            switch (getMockedString()) {
                case 'W':
                    computer = new ComputerWindows();
                    break;
                case 'L':
                    computer = new ComputerLinux();
                    break;
                default:
                    computer = new ComputerMac();
            }

            // I use something about IComputer
            computer.boot();
        }

        static char getMockedString() {
            return UUID.randomUUID().toString().charAt(0);
        }
    }
}
