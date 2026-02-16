package codesmell.polymorphism;

/**
 * Demonstrates the refactoring of a conditional polymorphism code smell using
 * the <b>Abstract Factory</b> pattern implemented via an Enum.
 *
 * <p>In this approach, the Enum {@link PeopleType} acts as a registry and factory.
 * Instead of containing the logic directly, it delegates behavior to a separate
 * hierarchy of classes ({@link People} and its subclasses).</p>
 *
 * Key Characteristic: Separation of concerns. The Enum handles the "Type",
 * while the classes handle the "Behavior".</p>
 */
public class MainAfterWithAbstractFactory {

    /**
     * Enum acting as a Factory/Registry for {@link People} instances.
     *
     * <p><b>WARNING - SINGLETON NATURE:</b>
     * Enums in Java are singletons. The instances (e.g., {@code new European()})
     * passed to the constructor are created <b>only once</b> when the class is loaded.
     * Consequently, {@code PeopleType.EUROPEAN.get()} will always return the
     * same object reference. This is thread-safe and efficient for stateless
     * strategies, but dangerous if the {@link People} classes have mutable state.</p>
     */
    enum PeopleType {
        EUROPEAN(new European()),
        AFRICAN(new African()),
        ASIAN(new Asian());

        private final People people;

        PeopleType(People people) {
            this.people = people;
        }

        /**
         * Retrieves the specific implementation associated with this enum constant.
         * @return The singleton instance of the specific {@link People} implementation.
         */
        public People get() {
            return people;
        }
    }

    /**
     * Abstract Product.
     * Defines the contract for the polymorphic behavior.
     */
    abstract static class People {
        abstract String getName();

        abstract int getSpeed();
    }

    /** Concrete Product implementation for European. */
    static class European extends People {
        String getName() {
            return "Aldo";
        }

        int getSpeed() {
            return 1000;
        }
    }

    /** Concrete Product implementation for African. */
    static class African extends People {
        String getName() {
            return "Giovanni";
        }

        int getSpeed() {
            return 99;
        }
    }

    /** Concrete Product implementation for Asian. */
    static class Asian extends People {
        String getName() {
            return "Giacomo";
        }

        int getSpeed() {
            return 33;
        }
    }

    /**
     * Client code demonstrating the Enum Abstract Factory usage.
     *
     * @param args command line arguments
     */
    public void main(String[] args) {
        //
        // NOTA BENE: ENUMS ARE SINGLETONS
        // Retrieving the instance delegator
        People people = PeopleType.AFRICAN.get();

        // respect Open/Closed Principle
        // The client relies on the abstraction, not the concrete implementation.
        people.getName();
        people.getSpeed();

        // we can also do dynamic retrieval via String
        PeopleType african = PeopleType.valueOf("ASIAN");
    }
}