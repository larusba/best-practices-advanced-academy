package parameter;

import java.util.UUID;

public class Main {

    public static class TaxCalculator {
        
        public static void setupTax() {
        }

        public static double getTax(int index) {
            // Implementation to retrieve tax based on index
            // This is just a placeholder implementation
            switch (index) {
                case 1:
                    return 10.0;
                case 2:
                    return 15.0;
                case 3:
                    return 20.0;
                default:
                    return 0.0;
            }
        }
    }

    public static class Game {

        public static void runGame() {
            // Implementation of game logic
            // For demonstration, we'll just set playerHealth based on level
        }

        public static int playerHealth() {
            return (int) (Math.random() * 100);
        }

        public static void setPlayerHealth(int playerHealth) {
            System.out.println("Game.setPlayerHealth");
        }
        
        public static void setLevel(int playerHealth) {
            System.out.println("Game.setLevel");
        }
    }

}
