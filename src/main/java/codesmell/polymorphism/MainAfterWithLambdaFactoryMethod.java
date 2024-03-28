package codesmell.polymorphism;

/**
 * We create different method based on enum
 */
public class MainAfterWithLambdaFactoryMethod {
    enum PeopleType {
        EUROPEAN("Aldo", 1000),
        AFRICAN("Giovanni", 99),
        ASIAN("Giacomo", 33);
        
        private final String name;
        private final int speed;

        PeopleType(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }
    }

    /**
     * Enum Factory Method Design Pattern without People interface
     * 
     * With multiple enum constructor parameter and complex methods
     *  is better to use the MainAfterWithAbstractFactory mode
     * for example --> getName(String something, int else) { .-long implementation.}
     *  we should do some lambdas --> `ASIAN( (something, else) -> { implementation } )` 
     */
    public void main(String[] args) {
        // 
        // NOTA BENE: ENUMS ARE SINGLETONS
        //
        PeopleType people = PeopleType.AFRICAN;

        // respect Open/Closed Principle
        people.getName();
        people.getSpeed();
        
        // we can also do
        PeopleType african = PeopleType.valueOf("ASIAN");
    }

}
