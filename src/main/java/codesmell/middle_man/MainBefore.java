package codesmell.middle_man;

/**
 * CODE SMELL: Middle Man (Intermediario).
 *
 * Questo smell si verifica quando una classe delega tutto (o quasi) il lavoro
 * a un'altra classe delegata (in questo caso, Bar).
 *
 * PROBLEMA:
 * - La classe Foo agisce come un inutile "passacarte".
 * - Se aggiungiamo nuove funzionalità a Bar, dobbiamo continuamente aggiornare
 * anche Foo per esporle.
 * - Si crea codice duplicato e inutile manutenzione.
 */
public class MainBefore {
    public class Foo {
        Bar bar;

        /**
         * ESEMPIO DI MIDDLE MAN.
         *
         * Questo metodo non fa altro che chiamare il metodo corrispondente su 'bar'.
         * Non aggiunge logica, validazione o controllo. È ridondante.
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

        // Il client non sa che sta usando Bar, passa tramite l'intermediario Foo.
        Foo impValue = a.getImpValue();
    }
}