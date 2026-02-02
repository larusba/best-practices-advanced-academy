package designpattern.memento;

import java.util.ArrayList;

/**
 * Esempio didattico del Design Pattern Memento.
 *
 * Questo pattern permette di catturare e salvare lo stato interno di un oggetto
 * senza violare l'incapsulamento, in modo da poter ripristinare l'oggetto
 * a tale stato in un secondo momento (es. operazioni di Undo/Redo).
 *
 * Concetti chiave:
 * - Originator: L'oggetto che possiede lo stato e crea il Memento.
 * - Memento: L'oggetto opaco che contiene lo snapshot dello stato.
 * - Caretaker: L'oggetto che custodisce la storia dei Memento.
 */
public class Main {

    /**
     * Memento: Rappresenta lo snapshot dello stato.
     *
     * In una implementazione ideale, questa classe dovrebbe essere "opaca" per il Caretaker
     * (non deve poter leggere i dati) ma accessibile per l'Originator.
     */
    static class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    /**
     * Originator: L'oggetto di business che cambia stato nel tempo.
     *
     * È l'unica classe autorizzata a creare un Memento del proprio stato corrente
     * e a usare un Memento per ripristinarsi.
     */
    static class Originator {
        private String state;
        /*
         * Nota didattica: Qui potrebbero esserci molti dati privati pesanti in memoria
         * che non servono per definire lo "stato" salvabile. Il Memento serve anche a
         * salvare solo ciò che è strettamente necessario per il ripristino.
         */

        public void setState(String state) {
            System.out.println("Originator: Setting state to " + state);
            this.state = state;
        }

        /**
         * Crea un "salvataggio" (snapshot) dello stato attuale.
         * @return Un nuovo oggetto Memento.
         */
        public Memento save() {
            System.out.println("Originator: Saving to Memento.");
            return new Memento(state);
        }

        /**
         * Ripristina lo stato interno usando un Memento salvato in precedenza.
         * @param m Il Memento da cui recuperare lo stato.
         */
        public void restore(Memento m) {
            state = m.getState();
            System.out.println("Originator: State after restoring from Memento: " + state);
        }
    }

    /**
     * Caretaker: Responsabile della custodia dei salvataggi (storia).
     *
     * Sa "quando" salvare o ripristinare l'Originator, ma non sa "cosa" c'è dentro il Memento.
     * Qui è implementato come una lista, ma spesso è uno Stack (LIFO) per gestire l'Undo.
     */
    static class Caretaker {
        private final ArrayList<Memento> mementos = new ArrayList<>();

        public void addMemento(Memento m) {
            mementos.add(m);
        }

        public Memento getMemento() {
            // Nota: in un caso reale passeremmo un indice o faremmo un pop().
            // Qui recuperiamo staticamente il secondo stato salvato (indice 1) per demo.
            return mementos.get(1);
        }
    }

    /**
     * Classe cliente che orchestra il flusso.
     *
     * Simula dei cambi di stato, effettua dei salvataggi tramite il Caretaker
     * e infine esegue un ripristino (rollback) a uno stato precedente.
     */
    public static class MementoDemo {
        public static void main(String[] args) {
            Caretaker caretaker = new Caretaker();
            Originator originator = new Originator();

            originator.setState("State1");
            originator.setState("State2");

            // Check-point: Salviamo lo stato "State2"
            caretaker.addMemento(originator.save());

            originator.setState("State3");

            // Check-point: Salviamo lo stato "State3"
            caretaker.addMemento(originator.save());

            originator.setState("State4");

            // Rollback: Torniamo indietro usando il Caretaker
            // Nota: getMemento() qui restituisce hardcoded l'indice 1 ("State3")
            originator.restore(caretaker.getMemento());
        }
    }
}