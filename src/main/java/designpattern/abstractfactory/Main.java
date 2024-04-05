package designpattern.abstractfactory;

public class Main {
    /**
     * COMPONENT: Abstract Product
     */
    abstract static class CPU {}

    /**
     * COMPONENT: Concrete Product
     */
    static class EmberCPU extends CPU {}

    // class EnginolaCPU
    static class EnginolaCPU extends CPU {}

    // class MMU
    abstract static class MMU {}

    // class EmberMMU
    static class EmberMMU extends MMU {}

    // class EnginolaMMU
    static class EnginolaMMU extends MMU {}

    /**
     * COMPONENT: Concrete Factory
     */
    static class EmberToolkit extends AbstractFactory {
        @Override
        public CPU createCPU() {
            return new EmberCPU();
        }

        @Override
        public MMU createMMU() {
            return new EmberMMU();
        }
    }

    // class EnginolaFactory
    static class EnginolaToolkit extends AbstractFactory {
        @Override
        public CPU createCPU() {
            return new EnginolaCPU();
        }

        @Override
        public MMU createMMU() {
            return new EnginolaMMU();
        }
    }

    enum Architecture {
        ENGINOLA,
        EMBER
    }

    abstract static class AbstractFactory {
        private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
        private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

        // Returns a concrete factory object that is an instance of the
        // concrete factory class appropriate for the given architecture.
        static AbstractFactory getFactory(Architecture architecture) {
            AbstractFactory factory = null;
            switch (architecture) {
                case ENGINOLA:
                    factory = ENGINOLA_TOOLKIT;
                    break;
                case EMBER:
                    factory = EMBER_TOOLKIT;
                    break;
            }
            return factory;
        }

        public abstract CPU createCPU();

        public abstract MMU createMMU();
    }

    public static class Client {
        public static void main(String[] args) {
            AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);

            //
            // createCPU() depends on class retrieved from abstract
            //
            CPU cpu = factory.createCPU();
        }
    }
}
