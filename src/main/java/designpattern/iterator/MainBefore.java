package designpattern.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ESEMPIO "BEFORE": Violazione dell'Incapsulamento.
 *
 * In questo approccio, il container (IntegerBox) espone direttamente la sua struttura
 * dati interna (la Lista) al client.
 *
 * PROBLEMI DIDATTICI:
 * - Accoppiamento Stretto: Il client deve sapere che IntegerBox usa una List/Collection.
 * - Sicurezza dei Dati: Il client può modificare (es. svuotare) la lista interna
 * senza che IntegerBox possa impedirlo o accorgersene.
 * - Limitazioni di Scorrimento: Non c'è un modo standard fornito dalla classe per
 * scorrere i dati; ci si affida all'implementazione della collezione sottostante.
 */
public class MainBefore {
    static class IntegerBox {
        private final List<Integer> list = new ArrayList<>();

        public void add(int in) {
            list.add(in);
        }

        /**
         * CODE SMELL: Esposizione delle interiora (Breaching Encapsulation).
         * Restituendo direttamente l'oggetto List, permettiamo a chiunque
         * di manipolare lo stato interno di questa classe.
         */
        public List getData() {
            return list;
        }
    }

    public static class IteratorDemo {
        public static void main(String[] args) {
            IntegerBox box = new IntegerBox();
            for (int i = 9; i > 0; --i) {
                box.add(i);
            }

            // Il client ottiene il riferimento diretto alla lista interna
            Collection integerList = box.getData();
            for (Object anIntegerList : integerList) {
                System.out.print(anIntegerList + "  ");
            }

            // DANGER ZONE: Il client modifica lo stato interno di IntegerBox!
            // Questo 'clear()' svuota la lista dentro 'box', probabilmente
            // causando bug inaspettati in altre parti del codice.
            integerList.clear();
            
            // Verifica del danno fatto
            integerList = box.getData();
            System.out.println("size of data is: " + integerList.size());
        }
    }
}