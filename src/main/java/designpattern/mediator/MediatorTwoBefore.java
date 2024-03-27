package designpattern.mediator;

/**
 * We’re building a simple cooling system that consists of a fan, a power supply, and a button.
 * Pressing the button will either turn on or turn off the fan. Before we turn the fan on, we need
 * to turn on the power. Similarly, we have to turn off the power right after the fan is turned off.
 */
public class MediatorTwoBefore {
    public static class Button {
        private Fan fan;

        // constructor, getters and setters

        public void press() {
            if (fan.isOn()) {
                fan.turnOff();
            } else {
                fan.turnOn();
            }
        }
    }

    public static class Fan {
        private Button button;
        private PowerSupplier powerSupplier;
        private boolean isOn = false;

        // constructor, getters and setters

        public void turnOn() {
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
