package codesmell.middle_man;

public class MainAfter {
    public class Foo {
        Bar bar;

        /**
         * We just use getBar() instead of the Middle Man, 
         * more generic and future proofing
         */
        public Bar getBar() {
            return bar;
        }
    }

    public class Bar {
        private final Foo impValue1;
        public Bar(Foo impValue) {
            impValue1 = impValue;
        }
        public Foo getImpValue(){
            return impValue1;
        }
    }

    public class Client {
        // do stuff..
        Foo a = new Foo();
        
        // getBar().getImpValue()
        Foo impValue = a.getBar().getImpValue();
    }
}
