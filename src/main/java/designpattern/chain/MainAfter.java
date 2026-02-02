package designpattern.chain;

import java.util.UUID;

/**
 * SOLUZIONE: Design Pattern Chain of Responsibility.
 *
 * Gli oggetti vengono collegati in una catena (Linked List).
 * Il Client invia la richiesta solo al primo anello della catena (rootChain)
 * senza sapere chi effettivamente gestirà o processerà la richiesta.
 *
 * VANTAGGI:
 * - Disaccoppiamento: Il mittente (Client) non conosce il destinatario specifico.
 * - Flessibilità: È possibile aggiungere o rimuovere anelli alla catena dinamicamente
 * usando il metodo add(), senza cambiare il codice del client.
 */
public class MainAfter {
    static class Handler {
        // Riferimento al prossimo anello della catena
        private Handler nextInChain;

        private final String id;

        public Handler() {
            id = UUID.randomUUID().toString();
        }

        /**
         * Costruisce la catena dinamicamente.
         * Se c'è già un successivo, delega a lui l'inserimento (ricorsione),
         * altrimenti imposta il nuovo handler come successivo.
         */
        public void add(Handler next) {
            if (nextInChain == null) {
                nextInChain = next;
            } else {
                nextInChain.add(next);
            }
        }

        public void execute() {
            System.out.println("do something..." + id);
            // NOTA DIDATTICA:
            // Spesso nel pattern Chain of Responsibility, qui si troverebbe una logica del tipo:
            // if (possoGestire) { ... } else if (nextInChain != null) { nextInChain.execute(); }
        }
    }

    public static class ChainDemo {
        public static void main(String[] args) {
            // Setup della catena
            Handler rootChain = new Handler();
            rootChain.add(new Handler());
            rootChain.add(new Handler());
            rootChain.add(new Handler());

            for (int i = 1; i < 6; i++) {
                System.out.println("Operation #" + i + ":");
                // Il client parla solo con la "testa" della catena.
                // Non c'è più nessun ciclo for o logica di selezione nel main.
                rootChain.execute();
            }
        }
    }
}