package codesmell.polymorphism;

/**
 * We create different instances based on enum
 */
public class MainAfterWithAbstractFactory {
    enum PeopleType {
        EUROPEAN(new European()),
        AFRICAN(new African()),
        ASIAN(new Asian());
        
        private final People people;

        PeopleType(People people) {
            this.people = people;
        }

        public People get() {
            return people;
        }
    }
    
    abstract static class People {
        abstract String getName();
        abstract int getSpeed();
    }

    static class European extends People {
        String getName() {
            return "Aldo";
        }
        int getSpeed() {
            return 1000;
        }
    }

    static class African extends People {
        String getName() {
            return "Giovanni";
        }
        int getSpeed() {
            return 99;
        }
    }

    static class Asian extends People {
        String getName() {
            return "Giacomo";
        }
        int getSpeed() {
            return 33;
        }
    }

    /**
     * Enum Factory Method Design Pattern
     */
    public void main(String[] args) {
        // 
        // NOTA BENE: ENUMS ARE SINGLETONS
        //
        People people = PeopleType.AFRICAN.get();

        // respect Open/Closed Principle
        people.getName();
        people.getSpeed();
        
        // we can also do
        PeopleType african = PeopleType.valueOf("ASIAN");
    }

}
