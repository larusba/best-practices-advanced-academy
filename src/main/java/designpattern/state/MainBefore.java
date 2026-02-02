package designpattern.state;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * PROBLEMA: Macchina a Stati finiti gestita con condizionali.
 *
 * Qui lo stato è rappresentato da un semplice intero (0, 1, 2, 3).
 *
 * CRITICITÀ:
 * - Violazione Open/Closed Principle: Per aggiungere una nuova velocità (es. "Turbo"),
 * dobbiamo modificare il metodo pull() e rischiare di rompere la logica esistente.
 * - Codice Spaghetti: Se le operazioni per ogni stato fossero complesse,
 * questo metodo diventerebbe enorme e illeggibile.
 * - Transizioni implicite: La logica di passaggio da uno stato all'altro è sepolta negli if/else.
 */
public class MainBefore {

    static class CeilingFanPullChain {
        // CODE SMELL: Uso di interi per rappresentare stati complessi.
        private int currentState;

        public CeilingFanPullChain() {
            currentState = 0;
        }

        /** Not good: bad "case" statement */
        public void pull() {
            // CODE SMELL: Catena condizionale rigida.
            // Il contesto deve conoscere tutti gli stati possibili e le regole di transizione.
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