package exercises_part2.ex14;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Accoppiamento Client:** Il Client deve conoscere tutti i dettagli (Luci, TV, AC) per guardare un film.
 *
 * FEATURE FUTURA:
 * - Implementare "Party Mode" che configura i sistemi in modo diverso.
 */
public class Exercise14Step1 {
    static class Lights { void dim() { System.out.println("Luci basse"); } }
    static class TV { void on() { System.out.println("TV accesa"); } }
    static class AC { void setTemp(int t) { System.out.println("AC a " + t); } }

    public static void main(String[] args) {
        // Client Code complesso
        Lights l = new Lights(); l.dim();
        TV tv = new TV(); tv.on();
        AC ac = new AC(); ac.setTemp(22);
    }
}