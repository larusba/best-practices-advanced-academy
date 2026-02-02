package designpattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ESEMPIO 1: Observer con Classe Astratta e Auto-registrazione.
 *
 * Concetto: Quando il Subject (il numero) cambia, notifica tutti gli observer
 * che devono ristampare il valore nel loro formato specifico (Hex, Oct, Bin).
 */
public class Main {
    /**
     * COMPONENT: Observer (Abstract)
     * Definisce il contratto per gli oggetti che devono essere notificati.
     * Mantiene un riferimento al Subject per poter "tirare" (Pull) i dati aggiornati.
     */
    abstract static class Observer {
        protected Subject subject;

        public abstract void update();
    }

    /**
     * COMPONENT: Subject (Soggetto / Observable)
     * Mantiene lo stato e la lista degli osservatori interessati.
     */
    static class Subject {
        private final List<Observer> observers = new ArrayList<>();
        private int state;

        public void add(Observer o) {
            observers.add(o);
        }

        public int getState() {
            return state;
        }

        /**
         * TRIGGER: Il metodo che cambia lo stato.
         * Dopo aver modificato il valore, chiama immediatamente execute() (notify).
         */
        public void setState(int value) {
            this.state = value;
            execute();
        }

        private void execute() {
            for (Observer observer : observers) {
                // Notifica tutti gli osservatori registrati
                observer.update();
            }
        }
    }

    /**
     * Concrete Observer A (Esadecimale)
     */
    static class HexObserver extends Observer {
        public HexObserver(Subject subject) {
            this.subject = subject;
            // AUTO-REGISTRAZIONE: L'observer si aggancia al subject nel costruttore.
            this.subject.add(this);
        }

        public void update() {
            // PULL MODEL: L'observer chiede al subject il nuovo stato (getState)
            System.out.print(" " + Integer.toHexString(subject.getState()));
        }
    }

    static class OctObserver extends Observer {
        public OctObserver(Subject subject) {
            this.subject = subject;
            this.subject.add(this);
        }

        public void update() {
            System.out.print(" " + Integer.toOctalString(subject.getState()));
        }
    }

    static class BinObserver extends Observer {
        public BinObserver(Subject subject) {
            this.subject = subject;
            this.subject.add(this);
        }

        public void update() {
            System.out.print(" " + Integer.toBinaryString(subject.getState()));
        }
    }

    public static class ObserverDemo {
        public static void main(String[] args) {
            Subject sub = new Subject();
            
            // Creando gli observer, essi si registrano automaticamente al Subject 'sub'
            new HexObserver(sub);
            new OctObserver(sub);
            new BinObserver(sub);
            
            Scanner scan = new Scanner(System.in);
            for (int i = 0; i < 5; i++) {
                System.out.print("\nEnter a number: ");
                // Il client non deve chiamare update() sugli observer.
                // Cambia solo lo stato del subject, la magia avviene dietro le quinte.
                sub.setState(scan.nextInt());
            }
        }
    }
}