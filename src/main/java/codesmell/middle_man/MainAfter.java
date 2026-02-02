package codesmell.middle_man;

/**
 * SOLUZIONE: Refactoring "Remove Middle Man".
 *
 * Abbiamo rimosso i metodi delega inutili dalla classe Foo.
 * Ora il client accede direttamente all'oggetto che compie il lavoro (Bar).
 *
 * VANTAGGI:
 * - La classe Foo si snellisce drasticamente.
 * - Non è necessario modificare Foo quando l'interfaccia di Bar cambia.
 *
 * NOTA:
 * Questo refactoring è l'opposto di "Hide Delegate" (Legge di Demetra).
 * Si applica quando la delegazione è così estesa che Foo diventa un semplice wrapper vuoto.
 */
public class MainAfter {
    public class Foo {
        Bar bar;

        /**
         * Invece di replicare tutti i metodi di Bar, forniamo un accesso diretto all'oggetto.
         * Il client chiamerà i metodi direttamente su Bar.
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

        public Foo getImpValue() {
            return impValue1;
        }
    }

    public class Client {
        // do stuff..
        Foo a = new Foo();

        // Accesso diretto: a -> getBar() -> getImpValue()
        // Abbiamo eliminato l'intermediario.
        Foo impValue = a.getBar().getImpValue();
    }
}