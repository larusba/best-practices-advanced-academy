package exercises_part2.ex20;

/**
 * STEP 2: DESIGN BRIDGE (RED)
 *
 * OBIETTIVO:
 * Separare la gerarchia `Remote` dalla gerarchia `Device`.
 * Il Remote contiene un riferimento al Device (Composizione).
 */
public class Exercise20Step2 {
    
    public interface Device {
        void enable();
        void disable();
    }

    public static class Remote {
        protected Device device;
        public Remote(Device d) { this.device = d; }
        
        public void togglePower() {
            // TODO: Implementare logica
        }
    }
}