package exercises_part2.ex10;

/**
 * STEP 1: CODICE LEGACY
 *
 * ANALISI CODE SMELL:
 * 1. **Accoppiamento Forte:** Il client usa `new Truck()` direttamente.
 * 2. **Violazione OCP:** Se voglio cambiare il tipo di trasporto in base a una regola, devo cambiare il client.
 *
 * FEATURE FUTURA:
 * - Aggiungere supporto per trasporto Aereo (Plane), senza modificare la logica di gestione logistica.
 */
public class Exercise10Step1 {
    public static class Logistics {
        public void deliverProduct(String type) {
            if (type.equals("ROAD")) {
                Truck t = new Truck();
                t.deliver();
            } else if (type.equals("SEA")) {
                Ship s = new Ship();
                s.deliver();
            }
        }
    }
    static class Truck { void deliver() { System.out.println("Brum brum"); } }
    static class Ship { void deliver() { System.out.println("Swish swish"); } }
}