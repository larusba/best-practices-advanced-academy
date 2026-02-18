package exercises_part2.ex14;

/**
 * REFACTORING COMPLETATO (GREEN)
 * 
 * FEATURE:
 * - Implementare "Party Mode" che configura i sistemi in modo diverso.
 */
public class Exercise14Step3 {
    public static class Lights {
        void dim() {
        }
    }

    public static class TV {
        void on() {
        }
    }

    public static class HomeFacade {
        private Lights lights;
        private TV tv;

        public HomeFacade(Lights l, TV t) {
            this.lights = l;
            this.tv = t;
        }

        public void watchMovie() {
            lights.dim();
            tv.on();
        }
    }
}