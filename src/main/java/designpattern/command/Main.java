package designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Esempio del Design Pattern Command.
 *
 * Questo pattern incapsula una richiesta come un oggetto, permettendo di:
 * - Parametrizzare i metodi con diverse richieste.
 * - Accodare o registrare richieste (come in questo esempio).
 * - Supportare operazioni annullabili (Undo/Redo).
 *
 * Concetto chiave:
 * Disaccoppiamento totale tra chi emette la richiesta (il Client che crea la lista)
 * e chi sa come eseguirla (le classi concrete che implementano Command).
 */
public class Main {
    
    /**
     * Interfaccia Command.
     * Dichiara il metodo per l'esecuzione di un'operazione.
     * Permette di trattare azioni completamente diverse (Programmare, Politica, Lavori domestici)
     * in modo uniforme (polimorfismo).
     */
    interface Command {
        void execute();
    }

    /** Concrete Command 1 */
    static class DomesticEngineer implements Command {
        public void execute() {
            System.out.println("take out the trash");
        }
    }

    /** Concrete Command 2 */
    static class Politician implements Command {
        public void execute() {
            System.out.println("take money from the rich, take votes from the poor");
        }
    }

    /** Concrete Command 3 */
    static class Programmer implements Command {
        public void execute() {
            System.out.println("sell the bugs, charge extra for the fixes");
        }
    }

    public static class CommandDemo {
        
        /**
         * Simula il Client che crea e configura i comandi.
         * In un sistema reale, questi comandi potrebbero arrivare da click dell'utente,
         * chiamate API o task schedulati.
         * * @return Una coda (Queue) di comandi pronti per essere eseguiti.
         */
        public static List produceRequests() {
            List<Command> commandList = new ArrayList<>();
            commandList.add(new DomesticEngineer());
            commandList.add(new Politician());
            commandList.add(new Programmer());
            return commandList;
        }

        /**
         * Simula l'Invoker (o un consumer di una coda).
         * * NOTA DIDATTICA:
         * Questo metodo non ha idea di *cosa* facciano i comandi.
         * Sa solo che deve chiamare .execute() su ognuno di essi.
         * Questo dimostra il disaccoppiamento.
         */
        public static void workOffRequests(List queue) {
            for (Object command : queue) {
                ((Command) command).execute();
            }
        }

        public static void main(String[] args) {
            // 1. Creazione e Accodamento (Store)
            List queue = produceRequests();

            // 2. Esecuzione differita (Execute)
            // L'esecuzione avviene in un secondo momento e potenzialmente
            // in un contesto diverso da quello di creazione.
            workOffRequests(queue);
        }
    }
}