package codesmell.polymorphism;

/**
 * PROBLEMA: Uso improprio di Switch/Case per gestire comportamenti diversi.
 *
 * Questo è un classico esempio di programmazione procedurale forzata in un contesto a oggetti.
 *
 * CRITICITÀ:
 * - Violazione Open/Closed Principle: Ogni volta che aggiungiamo un nuovo "tipo" di persona,
 * siamo costretti a modificare questa classe e ricompilare il codice esistente.
 * - Manutenibilità: Se la logica dentro i case diventa complessa, il metodo diventa illeggibile.
 * - Type Codes: L'uso di interi (int type) per definire la natura dell'oggetto è fragile.
 */
public class MainBefore {
    static class People {

        int type;

        public People(int type) {
            this.type = type;
        }

        /**
         * CODE SMELL:
         * Il comportamento cambia drasticamente in base a un flag/intero.
         * Questo switch dovrebbe essere sostituito da una gerarchia di classi.
         */
        String getSpeed() {
            switch (type) {
                case 1:
                    // This could be complex implementations
                    return "Aldo";
                case 2:
                    return "Giovanni";
                case 3:
                    return "Giacomo";
            }
            throw new RuntimeException("Should be unreachable");
        }
    }

    public void main(String[] args) {
        People object = new People(0);

        object.getSpeed();
    }
}