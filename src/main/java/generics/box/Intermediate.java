package generics.box;

public class Intermediate {

    public static class StringBox {
        private String object;

        public void set(String object) {
            this.object = object;
        }

        public String get() {
            return object;
        }
    }

    public static class IntegerBox {
        private Integer object;

        public void set(Integer object) {
            this.object = object;
        }

        public Integer get() {
            return object;
        }
    }

    /** No need cast, but duplicated classes */
    public static class WithGenericsExample {
        public static void main(String[] args) {
            StringBox stringBox = new StringBox();
            stringBox.set("Hello"); // String
            String str = stringBox.get();
            System.out.println(str);

            IntegerBox integerBox = new IntegerBox();
            integerBox.set(10); // Integer
            int num = integerBox.get(); // Need to cast
            System.out.println(num);
        }
    }
}
