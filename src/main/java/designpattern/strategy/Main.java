package designpattern.strategy;

import java.util.List;

public class Main {
    /** We have different interfaces of algos */
    interface SortStrategy {
        void sort(List<String> list);
    }

    static class QuickSortStrategyImpl implements SortStrategy {

        @Override
        public void sort(List<String> list) {
            System.out.println("List sorted using Quick sort implementation");
        }
    }

    static class BubbleSortStrategyImpl implements SortStrategy {

        @Override
        public void sort(List<String> list) {
            System.out.println("List sorted using Bubble sort implementation");
        }
    }

    interface SearchStrategy {
        String search(String s);
    }

    static class BinarySearchStrategyImpl implements SearchStrategy {
        @Override
        public String search(String s) {
            System.out.println("list is binary searched");
            return null;
        }
    }

    static class LinearSearchStrategyImpl implements SearchStrategy {

        @Override
        public String search(String s) {
            System.out.println("list is linearly searched");
            return null;
        }
    }

    /** We can choose the algo we inject into the constructor */
    static class Context {
        private SortStrategy sortStrategy;
        private SearchStrategy searchStrategy;

        public Context(SortStrategy sortStrategy, SearchStrategy searchStrategy) {
            this.sortStrategy = sortStrategy;
            this.searchStrategy = searchStrategy;
        }

        public void setSortStrategy(SortStrategy sortStrategy) {
            this.sortStrategy = sortStrategy;
        }

        public void setSearchStrategy(SearchStrategy searchStrategy) {
            this.searchStrategy = searchStrategy;
        }

        public void sort(List<String> list) {
            sortStrategy.sort(list);
        }

        public String search(String s) {
            // perform search
            return searchStrategy.search(s);
        }
    }

    public static void main(String[] args) {
        List<String> list = List.of("b", "a", "c");
        Context context = new Context(new BubbleSortStrategyImpl(), new BinarySearchStrategyImpl());
        context.sort(list);
        String searchedElement1 = context.search("b");
        System.out.println("searchedElement1 = " + searchedElement1);

        System.out.println("---------------");

        context.setSortStrategy(new QuickSortStrategyImpl());
        context.setSearchStrategy(new LinearSearchStrategyImpl());
        context.sort(list);
        String searchedElement2 = context.search("a");
        System.out.println("searchedElement2 = " + searchedElement2);
    }
}
