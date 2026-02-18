package exercises_part2.ex20;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Esplosione Classi (Cartesian Product):** Abbiamo `SonyRemote`, `SonyAdvancedRemote`, `SamsungRemote`, etc.
 * 2. **Rigidità:** Ereditarietà usata male per condividere implementazione.
 *
 * FEATURE FUTURA:
 * - Creare un `AdvancedRemote` che funzioni con TUTTI i device esistenti.
 */
public class Exercise20Step1 {
    // Ereditarietà rigida
    public static class Remote {
        public void turnOn() { System.out.println("Generic On"); }
    }
    
    public static class SonyRemote extends Remote {
        @Override public void turnOn() { System.out.println("Sony On"); }
    }
    
    public static class SamsungRemote extends Remote {
        @Override public void turnOn() { System.out.println("Samsung On"); }
    }
}