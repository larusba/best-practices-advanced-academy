package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * ESEMPIO "AFTER": Implementazione del Design Pattern Iterator.
 *
 * Questo pattern fornisce un modo per accedere sequenzialmente agli elementi
 * di un oggetto aggregato senza esporre la sua rappresentazione sottostante.
 *
 * VANTAGGI DIDATTICI:
 * - Incapsulamento: La lista interna (ArrayList) rimane private e inaccessibile.
 * - Single Responsibility: La logica di scorrimento (avanti, fine, current) è spostata
 * nel cursore (l'Iterator) e tolta dal container o dal client.
 * - Iterazioni Multiple: È possibile avere più iteratori attivi contemporaneamente
 * sulla stessa collezione, ognuno col proprio stato di avanzamento.
 */
public class MainAfter {
    static class IntegerBox {
        private List<Integer> list = new ArrayList<>();

        /**
         * L'Iterator Concreto.
         * Mantiene il riferimento alla posizione corrente nell'attraversamento.
         * Nota: Questa è una implementazione didattica (GoF style) che differisce
         * leggermente dall'interfaccia standard java.util.Iterator.
         */
        public class Iterator {
            private IntegerBox box;
            private java.util.Iterator iterator;
            private int value;

            public Iterator(IntegerBox integerBox) {
                box = integerBox;
            }

            // Inizializza o resetta l'iteratore
            public void first() {
                iterator = box.list.iterator();
                next();
            }

            // Avanza al prossimo elemento
            public void next() {
                try {
                    value = (Integer) iterator.next();
                } catch (NoSuchElementException ex) {
                    value = -1; // Valore sentinella per indicare la fine
                }
            }

            // Controlla se l'iterazione è finita
            public boolean isDone() {
                return value == -1;
            }

            // Recupera l'elemento corrente
            public int currentValue() {
                return value;
            }
        }

        public void add(int in) {
            list.add(in);
        }

        /**
         * Factory Method per ottenere un iteratore.
         * Il client non riceve la lista, ma un oggetto capace di navigarla.
         */
        public Iterator getIterator() {
            return new Iterator(this);
        }
    }

    public static class IteratorDemo {
        public static void main(String[] args) {
            IntegerBox integerBox = new IntegerBox();
            for (int i = 9; i > 0; --i) {
                integerBox.add(i);
            }
            
            // Otteniamo due istanze separate di iteratori.
            // Ognuno mantiene il proprio cursore indipendente.
            IntegerBox.Iterator firstItr = integerBox.getIterator();
            IntegerBox.Iterator secondItr = integerBox.getIterator();

            // Esempio 1: Scorrimento standard
            for (firstItr.first(); !firstItr.isDone(); firstItr.next()) {
                System.out.print(firstItr.currentValue() + "  ");
            }

            /**
             * Esempio 2: Iterazioni Simultanee.
             * Dimostrazione della potenza del pattern: possiamo scorrere la collezione
             * con due puntatori diversi contemporaneamente (utile es. per algoritmi di confronto).
             */
            for (firstItr.first(); secondItr.first();
                    !firstItr.isDone();
                    firstItr.next(), secondItr.next()) {
                System.out.print(firstItr.currentValue() + " " + secondItr.currentValue() + "  ");
            }
        }
    }
}