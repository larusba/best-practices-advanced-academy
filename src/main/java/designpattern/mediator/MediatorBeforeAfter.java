package designpattern.mediator;

/**
 * Everything seems to work fine. But notice how Button, Fan, and PowerSupplier classes are tightly
 * coupled. The Button operates directly on the Fan and the Fan interacts with both Button and
 * PowerSupplier.
 *
 * <p>It would be hard to reuse the Button class in other modules. Also, if we need to add a second
 * power supply into our system, then we would have to modify the Fan class’ logic.
 */
public class MediatorBeforeAfter {

    /**
     * NOTA BENE: If we need to add a second power supply in the future, all we have to do is to
     * update Mediator’s logic; Button and Fan classes remain untouched. This example shows how
     * easily we can separate dependent objects and make our system easier to maintain.
     */
    public static class Mediator {
        private Button button;
        private Fan fan;
        private PowerSupplier powerSupplier;

        // constructor, getters and setters

        public void press() {
            if (fan.isOn()) {
                fan.turnOff();
            } else {
                fan.turnOn();
            }
        }

        public void start() {
            powerSupplier.turnOn();
        }

        public void stop() {
            powerSupplier.turnOff();
        }
    }

    public static class Button {
        // NB: Mediator instead of Fun
        private Mediator mediator;

        // constructor, getters and setters

        public void press() {
            mediator.press();
        }
    }

    public static class Fan {
        // NB: Mediator instead of Button and PowerSupplier
        private Mediator mediator;
        private boolean isOn = false;

        // constructor, getters and setters

        public void turnOn() {
            mediator.start();
            isOn = true;
        }

        public void turnOff() {
            isOn = false;
            mediator.stop();
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
