package designpattern.mediator;

/**
 * ESEMPIO "AFTER": Refactoring con Design Pattern Mediator.
 *
 * Obiettivo del refactoring:
 * - Disaccoppiare Button, Fan e PowerSupplier.
 * - Centralizzare la logica di orchestrazione (Flusso di controllo) nel Mediator.
 *
 * VANTAGGI DIDATTICI:
 * - I componenti (Colleagues) non si conoscono tra loro (parlano solo col Mediator).
 * - Button diventa riusabile: sa solo che deve dire "sono stato premuto" a qualcuno.
 * - Estendibilità: Se aggiungiamo un secondo alimentatore, modificheremo solo il Mediator,
 * senza toccare il codice di Fan o Button (Open/Closed Principle).
 */
public class MediatorTwoAfter {

    /**
     * Il MEDIATOR Concreto.
     *
     * Agisce da hub centrale. Conosce tutti i componenti e decide come coordinarli.
     * Trasforma le dipendenze molti-a-molti in dipendenze uno-a-molti.
     */
    public static class Mediator {
        /**
         * Riferimenti ai "Colleagues".
         * Il Mediator è l'unico posto dove questi oggetti coesistono.
         */
        private Button button;
        private Fan fan;
        private PowerSupplier powerSupplier;

        // constructor, getters and setters

        /**
         * Logica centralizzata.
         * Il Mediator riceve l'input dal Button e orchestra Fan.
         */
        public void press() {
            if (fan.isOn()) {
                fan.turnOff();
            } else {
                fan.turnOn();
            }
        }

        /**
         * Logica centralizzata.
         * Il Mediator riceve l'input dal Fan e orchestra PowerSupplier.
         */
        public void start() {
            powerSupplier.turnOn();
        }

        public void stop() {
            powerSupplier.turnOff();
        }
    }

    /**
     * COLLEAGUE 1: Button.
     *
     * Ora è un componente "stupido" (in senso buono).
     * Non sa cosa succede quando viene premuto, delega tutto al Mediator.
     */
    public static class Button {
        // NB: Dipende dall'interfaccia Mediator, non da classi concrete come Fan.
        private Mediator mediator;

        // constructor, getters and setters

        public void press() {
            mediator.press();
        }
    }

    /**
     * COLLEAGUE 2: Fan.
     *
     * Non controlla più direttamente il PowerSupplier.
     * Notifica il Mediator quando cambia stato (start/stop).
     */
    public static class Fan {
        // NB: Mediator sostituisce le dipendenze dirette verso Button e PowerSupplier.
        private Mediator mediator;
        private boolean isOn = false;

        // constructor, getters and setters

        public void turnOn() {
            // Notifica il mediatore che serve energia
            mediator.start();
            isOn = true;
        }

        public void turnOff() {
            isOn = false;
            // Notifica il mediatore di spegnere l'energia
            mediator.stop();
        }

        public boolean isOn() {
            return isOn;
        }
    }

    /**
     * COLLEAGUE 3: PowerSupplier.
     *
     * Rimane un componente passivo, controllato dal Mediator.
     */
    public static class PowerSupplier {
        public void turnOn() {
            // implementation
        }

        public void turnOff() {
            // implementation
        }
    }
}