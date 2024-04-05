package designpattern.template;

public class Main {
    
    public static class TemplateMethodDemo {
        public static void main(String[] args) {
            Generalization algorithm = new Realization();
            algorithm.findSolution();
        }
    }
    
    abstract static class Generalization {
        /**
         * Standardize the skeleton of an algorithm in a "template" method
         *
         * <p>The step can mutate, based on class
         */
        void findSolution() {
            stepOne();
            stepTwo();
            stepThr();
            stepFor();
        }
        //
        // 2. COMMON implementations of individual steps are defined in base class
        //
        private void stepOne() {
            System.out.println("Generalization.stepOne");
        }

        /** MUTABLE PART */
        abstract void stepTwo();

        abstract void stepThr();

        /** MUTABLE only for some subclasses */
        void stepFor() {
            System.out.println("Generalization.stepFor");
        }
    }

    abstract static class Specialization extends Generalization {
        // 4. Derived classes can override placeholder methods
        // 1. Standardize the skeleton of an algorithm in a "template" method
        protected void stepThr() {
            step3_1();
            step3_2();
            step3_3();
        }
        //
        // 2. COMMON implementations of individual steps are defined in base class
        //
        private void step3_1() {
            System.out.println("Specialization.step3_1");
        }
        // 3. Steps requiring peculiar implementations are "placeholders" in the base class
        protected abstract void step3_2();

        private void step3_3() {
            System.out.println("Specialization.step3_3");
        }
    }

    static class Realization extends Specialization {
        // 4. Derived classes can override placeholder methods
        protected void stepTwo() {
            System.out.println("Realization.stepTwo");
        }

        protected void step3_2() {
            System.out.println("Realization.step3_2");
        }

        // 5. Derived classes can override implemented methods
        // 6. Derived classes can override and "call back to" base class methods
        protected void stepFor() {
            System.out.println("Realization.stepFor");
            super.stepFor();
        }
    }
}
