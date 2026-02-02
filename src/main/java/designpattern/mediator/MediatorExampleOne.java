package designpattern.mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esempio del Design Pattern Mediator applicato in un contesto di concorrenza.
 *
 * Il Mediator agisce come "Hub" centrale per la comunicazione, disaccoppiando
 * completamente i mittenti (Producers) dai destinatari (Consumers).
 *
 * Concetti chiave:
 * - Disaccoppiamento: I Producer non sanno dell'esistenza dei Consumer e viceversa.
 * - Centralizzazione: La logica complessa di sincronizzazione (wait/notify) è
 * incapsulata interamente nel Mediator, non sparpagliata nei thread.
 */
public class MediatorExampleOne {

    /**
     * Il Mediator Concreto.
     *
     * Gestisce lo stato condiviso e arbitra lo scambio di messaggi.
     * Implementa un buffer di dimensione 1 (single slot) thread-safe.
     */
    static class Mediator {
        private boolean slotFull = false;
        private int number;

        /**
         * Metodo usato dai Producer per inviare dati.
         *
         * Se lo slot è pieno, mette il thread in attesa (wait).
         * Quando lo slot si libera, salva il dato e notifica i thread in attesa.
         */
        public synchronized void storeMessage(int num) {
            // no room for another message
            while (slotFull == true) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            slotFull = true;
            number = num;
            notifyAll();
        }

        /**
         * Metodo usato dai Consumer per leggere dati.
         *
         * Se lo slot è vuoto, mette il thread in attesa.
         * Quando arriva un dato, lo preleva, libera lo slot e notifica i Producer.
         */
        public synchronized int retrieveMessage() {
            // no message to retrieve
            while (slotFull == false) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            slotFull = false;
            notifyAll();
            return number;
        }
    }

    /**
     * Colleague 1: Producer.
     *
     * Genera dati e li invia al Mediator.
     * Non ha riferimenti ai Consumer, conosce solo l'interfaccia del Mediator.
     */
    static class Producer implements Runnable {
        private Mediator med;
        private int id;
        private static int num = 1;

        public Producer(Mediator m) {
            med = m;
            id = num++;
        }

        @Override
        public void run() {
            int num;
            while (true) {
                med.storeMessage(num = (int) (Math.random() * 100));
                System.out.print("p" + id + "-" + num + "  ");
            }
        }
    }

    /**
     * Colleague 2: Consumer.
     *
     * Richiede dati al Mediator.
     * Ignora chi o quanti Producer stiano generando i dati.
     */
    static class Consumer implements Runnable {
        private final Mediator med;
        private final int id;
        private static int num = 1;

        public Consumer(Mediator m) {
            med = m;
            id = num++;
        }

        @Override
        public void run() {
            while (true) {
                System.out.print("c" + id + "-" + med.retrieveMessage() + "  ");
            }
        }
    }

    /**
     * Classe Client.
     *
     * Configura la rete di oggetti: crea il Mediator e collega i Colleague (thread).
     */
    public static class MediatorDemo {
        public static void main(String[] args) {
            List<Thread> producerList = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Press ENTER for exit");

            // Istanzia il Mediator che gestirà il traffico tra thread
            Mediator mb = new Mediator();

            // I thread ricevono solo il riferimento al Mediator
            producerList.add(new Thread(new Producer(mb)));
            producerList.add(new Thread(new Producer(mb)));
            producerList.add(new Thread(new Consumer(mb)));
            producerList.add(new Thread(new Consumer(mb)));
            producerList.add(new Thread(new Consumer(mb)));
            producerList.add(new Thread(new Consumer(mb)));

            for (Thread p : producerList) {
                p.start();
            }

            boolean stop = false;
            String exit = scanner.nextLine();
            while (!stop) {
                if (exit.equals("")) {
                    stop = true;
                    for (Thread p : producerList) {
                        // AVVISO DIDATTICO:
                        // Thread.stop() è deprecato e insicuro (unsafe).
                        // In codice di produzione bisognerebbe usare un flag volatile
                        // o Thread.interrupt() per una chiusura pulita.
                        // Qui è usato solo per semplicità dell'esempio.
                        //noinspection deprecation
                        p.stop();
                    }
                }
            }
        }
    }
}