package generics.box;

public class Before {

    public static class Box {
        private Object object;

        public void set(Object object) {
            this.object = object;
        }

        public Object get() {
            return object;
        }
    }


    public static class WithGenericsExample {
        public static void main(String[] args) {
            Box box = new Box();
            box.set("Hello"); // String
            String str = (String) box.get(); // Need to cast
            System.out.println(str);

            box.set(10); // Integer
            int num = (int) box.get(); // Need to cast
            System.out.println(num);
        }
    }
}
