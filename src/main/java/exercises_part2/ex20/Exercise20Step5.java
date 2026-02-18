package exercises_part2.ex20;

public class Exercise20Step5 {
    // Aggiungiamo setVolume all'interfaccia Device (evoluzione)
    public interface Device extends Exercise20Step3.Device {
        void setVolume(int percent);
    }
    
    public static class AdvancedRemote extends Exercise20Step3.Remote {
        public AdvancedRemote(Device d) { super(d); }
        
        public void mute() {
            ((Device)device).setVolume(0); // Feature aggiuntiva
        }
    }
}