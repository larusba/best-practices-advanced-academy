package exercises_part2.ex14;

public class Exercise14Step4 {
    // Copia classi step 3
    static class Lights { void dim() {} void strobe() {} } // strobe aggiunto
    static class TV { void on() {} }
    static class Stereo { void loud() {} } // Nuovo sottosistema

    public static class HomeFacade {
        private Lights l; private TV t; private Stereo s;
        public HomeFacade(Lights l, TV t, Stereo s) { this.l=l; this.t=t; this.s=s; }
        
        public void partyMode() {
            // TODO
        }
    }
}