package exercises_part2.ex14;

public class Exercise14Step5 {
    static class Lights {
        void strobe() {
        }
    }

    static class Stereo {
        void loud() {
        }
    }

    public static class HomeFacade {
        private Lights lights;
        private Stereo stereo;

        public HomeFacade(Lights l, Stereo s) {
            this.lights = l;
            this.stereo = s;
        }

        public void partyMode() {
            lights.strobe();
            stereo.loud();
        }
    }
}