package codesmell.polymorphism;

/**
 * Demonstrates a simplified polymorphic approach using a <b>Rich Enum</b>
 * (often referred to as a variation of the Factory Method or Strategy pattern).
 *
 * <p>In this approach, there is no separate class hierarchy. The state (fields)
 * and behavior (methods) are defined directly within the Enum constants.</p>
 *
 * PRO: Extremely concise for simple data/behavior pairs.</p>
 * CONS: Can become a "God Class" if the logic for each type becomes complex.</p>
 */
public class MainAfterWithFactoryMethod {

    /**
     * Enum that encapsulates both the type definition and the specific data/behavior.
     * Each constant acts as a specific configuration.
     */
    enum PeopleType {
        // The data is injected directly into the Enum constant
        EUROPEAN("Aldo", 1000),
        AFRICAN("Giovanni", 99),
        ASIAN("Giacomo", 33);

        private final String name;
        private final int speed;

        /**
         * Constructor for the Enum constants.
         * @param name The name associated with the people type.
         * @param speed The speed value associated with the people type.
         */
        PeopleType(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        /**
         * specific behavior/data for the enum constant.
         * @return the name.
         */
        public String getName() {
            return name;
        }

        /**
         * specific behavior/data for the enum constant.
         * @return the speed.
         */
        public int getSpeed() {
            return speed;
        }
    }

    /**
     * Client code demonstrating the Enum Factory/Strategy usage.
     *
     * @param args command line arguments
     */
    public void main(String[] args) {
        // Direct usage of the Enum constant which holds the data
        PeopleType people = PeopleType.AFRICAN;

        // respect Open/Closed Principle
        // Adding a new type (e.g., AMERICAN) only requires adding a line in the Enum,
        // without modifying the client code.
        people.getName();
        people.getSpeed();

        // Dynamic lookup
        PeopleType african = PeopleType.valueOf("ASIAN");
    }
}