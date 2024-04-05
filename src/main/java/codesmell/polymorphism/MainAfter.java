package codesmell.polymorphism;

public class MainAfter {
    abstract static class People {
        // ...
        abstract String getSpeed();
    }

    static class European extends People {
        String getSpeed() {
            return "Aldo";
        }
    }

    static class African extends People {
        String getSpeed() {
            return "Giovanni";
        }
    }

    static class Asian extends People {
        String getSpeed() {
            return "Giacomo";
        }
    }

    /** Most of the time, we could solve it using an Enum Factory Design Pattern See */
    public static void main(String[] args) {
        African object = new African();

        // respect Open/Closed Principle
        object.getSpeed();
    }
}
