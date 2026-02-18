package exercises_part2.ex20;

public class Exercise20Step3 {
    public interface Device {
        void enable();
        void disable();
        boolean isEnabled();
    }

    public static class Remote {
        protected Device device;
        public Remote(Device d) { this.device = d; }
        
        public void togglePower() {
            if (device.isEnabled()) device.disable();
            else device.enable();
        }
    }

    // Concrete Implementor
    public static class TV implements Device {
        boolean on = false;
        public void enable() { on = true; }
        public void disable() { on = false; }
        public boolean isEnabled() { return on; }
    }
}