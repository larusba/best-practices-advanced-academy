package designpattern.chain;

import java.util.List;
import java.util.UUID;

/**
 * PROBLEMA: Gestione manuale della sequenza.
 *
 * Senza il pattern Chain of Responsibility, il Client (ChainDemo) è costretto a:
 * - Mantenere un riferimento a TUTTI i gestori (List<Handler>).
 * - Implementare la logica di iterazione.
 * - Decidere esplicitamente quale handler deve eseguire l'azione.
 *
 * SVANTAGGI:
 * - Accoppiamento Stretto: Il client conosce l'intera collezione.
 * - Rigidità: Cambiare l'ordine o la logica di selezione richiede modifiche al client.
 */
public class MainBefore {
    static class Handler {
        private final String id;

        public Handler() {
            id = UUID.randomUUID().toString();
        }

        public void execute() {
            System.out.println("do something..." + id);
        }

        public String getId() {
            return id;
        }
    }

    public static class ChainDemo {
        public static void main(String[] args) {
            List<Handler> handlers =
                    List.of(
                            new Handler(),
                            new Handler(),
                            new Handler(),
                            // the last one is the true executor
                            new Handler());
            for (int i = 1; i < 6; i++) {
                System.out.println("Operation #" + i + ":");

                // CODE SMELL: Logica di business nel Client.
                // Il client itera manualmente per cercare il candidato giusto.
                for (Handler handler : handlers) {
                    //
                    // to know what is the current executor
                    //
                    if (handler.equals(handlers.get(handlers.size() - 1))) {
                        handler.execute();
                    }
                }
            }
        }
    }
}