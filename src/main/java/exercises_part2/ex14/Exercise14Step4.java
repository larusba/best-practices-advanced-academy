package exercises_part2.ex14;

/**
 * FEATURE:
 * - Implementare "Party Mode" che configura i sistemi in modo diverso.
 */
public class Exercise14Step4 {
    // strobe aggiunto
    public static class Lights {
        void dim() {
        }

        void strobe() {
        }
    }

    // Nuovo sottosistema
    public static class TV {
        void on() {
        }
    }

    public static class Stereo {
        void loud() {
        }
    }

    public static class HomeFacade {
        private Lights l;
        private TV t;
        private Stereo s;

        public HomeFacade(Lights l, TV t, Stereo s) {
            this.l = l;
            this.t = t;
            this.s = s;
        }

        public void partyMode() {
            // TODO
        }
    }
}