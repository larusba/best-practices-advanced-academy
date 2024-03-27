package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MainAfter {
    static class IntegerBox {
        private List<Integer> list = new ArrayList<>();

        public class Iterator {
            private IntegerBox box;
            private java.util.Iterator iterator;
            private int value;

            public Iterator(IntegerBox integerBox) {
                box = integerBox;
            }

            public void first() {
                iterator = box.list.iterator();
                next();
            }

            public void next() {
                try {
                    value = (Integer) iterator.next();
                } catch (NoSuchElementException ex) {
                    value = -1;
                }
            }

            public boolean isDone() {
                return value == -1;
            }

            public int currentValue() {
                return value;
            }
        }

        public void add(int in) {
            list.add(in);
        }

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
            // we use Iterator.
            IntegerBox.Iterator firstItr = integerBox.getIterator();
            IntegerBox.Iterator secondItr = integerBox.getIterator();
            for (firstItr.first(); !firstItr.isDone(); firstItr.next()) {
                System.out.print(firstItr.currentValue() + "  ");
            }

            /**
             * Two simultaneous iterations
             *
             * <p>We could also use 2 different interator with 2 different next() for example
             */
            for (firstItr.first(), secondItr.first();
                    !firstItr.isDone();
                    firstItr.next(), secondItr.next()) {
                System.out.print(firstItr.currentValue() + " " + secondItr.currentValue() + "  ");
            }
        }
    }
}
