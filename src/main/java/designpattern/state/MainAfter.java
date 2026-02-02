package designpattern.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SOLUZIONE: Design Pattern State.
 *
 * Ogni stato possibile diventa una classe.
 * Il comportamento cambia a runtime sostituendo l'oggetto di stato corrente all'interno del contesto.
 *
 * VANTAGGI:
 * - Single Responsibility: Ogni classe stato gestisce solo la propria logica.
 * - Transizioni Esplicite: Ogni stato sa qual è il prossimo (es. Low sa che dopo viene Medium).
 * - Pulizia: Il metodo pull() del contesto è puramente delegativo.
 */
public class MainAfter {
    /**
     * COMPONENT: State Interface.
     * Definisce il comportamento che ogni stato deve implementare.
     */
    interface State {
        // Passiamo il wrapper (Context) per permettere allo stato di cambiare
        // lo stato attivo nel contesto (transizione).
        void pull(CeilingFanPullChain wrapper);
    }

    /**
     * COMPONENT: Context.
     * Mantiene un riferimento allo stato corrente.
     */
    static class CeilingFanPullChain {
        private State currentState;

        public CeilingFanPullChain() {
            // Stato iniziale
            currentState = new Off();
        }

        public void setState(State s) {
            currentState = s;
        }

        public void pull() {
            // DELEGA: "Non so cosa succederà, chiedilo allo stato corrente".
            currentState.pull(this);
        }
    }

    /** Concrete State 1 */
    static class Off implements State {
        public void pull(CeilingFanPullChain wrapper) {
            // Logica di transizione: Da Off si passa a Low.
            wrapper.setState(new Low());
            System.out.println("low speed");
        }
    }

    /** Concrete State 2 */
    static class Low implements State {
        public void pull(CeilingFanPullChain wrapper) {
            // Logica di transizione: Da Low si passa a Medium.
            wrapper.setState(new Medium());
            System.out.println("medium speed");
        }
    }

    /** Concrete State 3 */
    static class Medium implements State {
        public void pull(CeilingFanPullChain wrapper) {
            // Logica di transizione: Da Medium si passa a High.
            wrapper.setState(new High());
            System.out.println("high speed");
        }
    }

    /** Concrete State 4 */
    static class High implements State {
        public void pull(CeilingFanPullChain wrapper) {
            // Logica di transizione: Da High si torna a Off.
            wrapper.setState(new Off());
            System.out.println("turning off");
        }
    }

    /** NB: start the main and press enters... */
    public static class StateDemo {
        public static void main(String[] args) {
            CeilingFanPullChain chain = new CeilingFanPullChain();
            for (int i = 0; i < 100; i++) {
                System.out.print("Press ENTER");
                getLine();
                chain.pull();
            }
        }

        // capture input
        static String getLine() {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            try {
                line = in.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return line;
        }
    }
}