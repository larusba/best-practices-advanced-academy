package designpattern.abstractfactory;

/** We create different METHODS based on enum */
public class ExampleDiffWithFactoryMethod {
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

    /** Enum Factory Method Design Pattern */
    public void main(String[] args) {
        PeopleType people = PeopleType.AFRICAN;

        // respect Open/Closed Principle
        people.getName();
        people.getSpeed();

        // we can also do
        PeopleType african = PeopleType.valueOf("ASIAN");
    }
}
