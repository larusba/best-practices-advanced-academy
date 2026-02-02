package designpattern.mediator;

/**
 * ESEMPIO "BEFORE": Violazione del principio di disaccoppiamento.
 *
 * Questo codice mostra un sistema "Tightly Coupled" (fortemente accoppiato).
 * Le classi dipendono direttamente dalle implementazioni concrete delle altre,
 * creando una catena di dipendenze rigida: Button -> Fan -> PowerSupplier.
 *
 * PROBLEMI DIDATTICI:
 * - Scarsa Riusabilità: Non possiamo usare questo Button per accendere una Lampada
 * perché contiene un riferimento esplicito a Fan.
 * - Manutenibilità: Se cambiamo la logica di accensione (es. serve più tensione),
 * dobbiamo modificare la classe Fan, violando il Single Responsibility Principle.
 * - Testabilità: Per testare il Button, siamo costretti a istanziare anche Fan e PowerSupplier.
 */
public class MediatorTwoBefore {

    /**
     * Classe Button (Codice Accoppiato).
     *
     * Problema:
     * - Contiene un riferimento diretto a 'Fan'.
     * - Gestisce la logica di controllo (if/else) che dovrebbe appartenere al sistema, non al bottone.
     */
    public static class Button {
        private Fan fan;

        // constructor, getters and setters

        public void press() {
            // CODE SMELL: Il bottone conosce troppo dello stato interno del ventilatore.
            if (fan.isOn()) {
                fan.turnOff();
            } else {
                fan.turnOn();
            }
        }
    }

    /**
     * Classe Fan (Codice Accoppiato).
     *
     * Problema:
     * - Dipende direttamente da PowerSupplier.
     * - Mescola la logica di "essere acceso" con la logica di "alimentazione elettrica".
     */
    public static class Fan {
        private Button button; // Dipendenza ciclica potenziale o inutile qui
        private PowerSupplier powerSupplier;
        private boolean isOn = false;
        

        public void turnOn() {
            // CODE SMELL: Fan controlla direttamente il ciclo di vita del PowerSupplier.
            powerSupplier.turnOn();
            isOn = true;
        }

        public void turnOff() {
            isOn = false;
            powerSupplier.turnOff();
        }

        public boolean isOn() {
            return isOn;
        }
    }

    public static class PowerSupplier {
        public void turnOn() {
            // implementation
        }

        public void turnOff() {
            // implementation
        }
    }
}