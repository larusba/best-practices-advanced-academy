package designpattern.memento;

import java.util.ArrayList;

public class Main {
    static class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    static class Originator {
        private String state;
        /* lots of memory consumptive private data that is not necessary to define the
         * state and should thus not be saved. Hence the small memento object. */

        public void setState(String state) {
            System.out.println("Originator: Setting state to " + state);
            this.state = state;
        }

        public Memento save() {
            System.out.println("Originator: Saving to Memento.");
            return new Memento(state);
        }

        public void restore(Memento m) {
            state = m.getState();
            System.out.println("Originator: State after restoring from Memento: " + state);
        }
    }

    static class Caretaker {
        private final ArrayList<Memento> mementos = new ArrayList<>();

        public void addMemento(Memento m) {
            mementos.add(m);
        }

        public Memento getMemento() {
            return mementos.get(1);
        }
    }

    public static class MementoDemo {
        public static void main(String[] args) {
            Caretaker caretaker = new Caretaker();
            Originator originator = new Originator();
            originator.setState("State1");
            originator.setState("State2");
            // add check-point
            caretaker.addMemento(originator.save());
            originator.setState("State3");

            // add check-point
            caretaker.addMemento(originator.save());
            originator.setState("State4");

            // go to check-point
            originator.restore(caretaker.getMemento());
        }
    }
}
