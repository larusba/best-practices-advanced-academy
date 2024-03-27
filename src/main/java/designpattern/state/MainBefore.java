package designpattern.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainBefore {

    static class CeilingFanPullChain {
        private int currentState;

        public CeilingFanPullChain() {
            currentState = 0;
        }

        /** Not good: bad "case" statement */
        public void pull() {
            if (currentState == 0) {
                currentState = 1;
                System.out.println("low speed");
            } else if (currentState == 1) {
                currentState = 2;
                System.out.println("medium speed");
            } else if (currentState == 2) {
                currentState = 3;
                System.out.println("high speed");
            } else {
                currentState = 0;
                System.out.println("turning off");
            }
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
