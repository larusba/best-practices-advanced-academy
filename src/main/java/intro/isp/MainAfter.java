package intro.isp;

public class MainAfter {
    /** only method common in all animal implementations */
    interface Animal {
        void breath();
    }

    /** rather than Animal interface, we use waterAnimal and AirAnimal interface */
    interface WaterAnimal {
        void swim();
    }

    interface AirAnimal {
        void fly();
    }

    class Fish implements WaterAnimal {
        public void swim() {
            System.out.println("Fish swims");
        }
    }
}
