package exercises_part2.ex14;

public class Exercise14Step3 {
    static class Lights { void dim() {} }
    static class TV { void on() {} }

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