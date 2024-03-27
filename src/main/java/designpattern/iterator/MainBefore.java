package designpattern.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainBefore {
    static class IntegerBox {
        private final List<Integer> list = new ArrayList<>();

        public void add(int in) {
            list.add(in);
        }

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
            Collection integerList = box.getData();
            for (Object anIntegerList : integerList) {
                System.out.print(anIntegerList + "  ");
            }

            integerList.clear();
            integerList = box.getData();
            System.out.println("size of data is: " + integerList.size());
        }
    }
}
