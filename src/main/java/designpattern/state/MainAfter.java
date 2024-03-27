package designpattern.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainAfter {
    interface State {
        void pull(CeilingFanPullChain wrapper);
    }

    static class CeilingFanPullChain {
        private State currentState;

        public CeilingFanPullChain() {
            currentState = new Off();
        }

        public void setState(State s) {
            currentState = s;
        }

        public void pull() {
            currentState.pull(this);
        }
    }

    static class Off implements State {
        public void pull(CeilingFanPullChain wrapper) {
            wrapper.setState(new Low());
            System.out.println("low speed");
        }
    }

    static class Low implements State {
        public void pull(CeilingFanPullChain wrapper) {
            wrapper.setState(new Medium());
            System.out.println("medium speed");
        }
    }

    static class Medium implements State {
        public void pull(CeilingFanPullChain wrapper) {
            wrapper.setState(new High());
            System.out.println("high speed");
        }
    }

    static class High implements State {
        public void pull(CeilingFanPullChain wrapper) {
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
