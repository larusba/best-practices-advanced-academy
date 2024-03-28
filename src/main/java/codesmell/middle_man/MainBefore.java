package codesmell.middle_man;

public class MainBefore {
    public class Foo {
        Bar bar;

        /**
         * This is a Middle Man, it just calls `bar` and do stuff using it
         */
        public Foo getImpValue() {
            return bar.getImpValue();
        }
    }

    public class Bar {
        private final Foo impValue1;
        public Bar(Foo impValue) {
            impValue1 = impValue;
        }
        public Foo getImpValue() {
            return impValue1;
        }
    }

    public class Client {
        // do stuff..
        Foo a = new Foo();

        // getImpValue()
        Foo impValue = a.getImpValue();
    }
}
