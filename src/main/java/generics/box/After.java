package generics.box;

public class After {
    // GenericBox.java
    public static class GenericBox<T> {
        private T object;

        public void set(T object) {
            this.object = object;
        }

        public T get() {
            return object;
        }
    }

    /** No need cast, but duplicated classes */
    public static class WithGenericsExample {
        public static void main(String[] args) {
            GenericBox<String> box1 = new GenericBox<>();
            box1.set("Hello");
            String str = box1.get(); // No need to cast
            System.out.println(str);

            GenericBox<Integer> box2 = new GenericBox<>();
            box2.set(10);
            int num = box2.get(); // No need to cast
            System.out.println(num);
        }
    }
}
