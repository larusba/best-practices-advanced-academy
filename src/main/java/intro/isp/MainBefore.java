package intro.isp;

public class MainBefore {
    interface Animal {
        void breath();

        void fly();

        void swim();
    }

    class Fish implements Animal {
        /** Useless... */
        public void swim() {
            System.out.println("Fish swims");
        }

        @Override
        public void breath() {}

        public void fly() {
            // Fish cannot fly, AFAIK
        }
    }
}
