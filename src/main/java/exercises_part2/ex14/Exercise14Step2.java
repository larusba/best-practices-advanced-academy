package exercises_part2.ex14;

/**
 * STEP 2: DESIGN FACADE (RED)
 *
 * OBIETTIVO:
 * Creare una classe `HomeFacade` che esponga metodi semplici come `watchMovie()`.
 */
public class Exercise14Step2 {
    static class Lights { void dim() {} }
    static class TV { void on() {} }

    public static class HomeFacade {
        private Lights lights;
        private TV tv;
        
        // Costruttore stub
        public HomeFacade(Lights l, TV t) { this.lights = l; this.tv = t; }

        public void watchMovie() {
            // TODO: Orchestrare
        }
    }
}