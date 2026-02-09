package designpattern.abstract_factory;

/**
 * Variazione del pattern Abstract Factory utilizzando le Enum come registro di istanze.
 *
 * DIFFERENZA RISPETTO ALL'ESEMPIO PRECEDENTE:
 * - Prima (ExampleDiffWithFactoryMethod): La logica era scritta direttamente dentro l'Enum.
 * - Qui: L'Enum funge solo da "Container". Le implementazioni reali sono delegate
 * a classi separate (European, African, Asian) che estendono una classe base.
 * 
 *  QUAL È MIGLIORE? Dipende, dalla complessità della logica.
 *      - Se `European()` etc sono molto complesse --> Abstract
 *      - Se sono molto semplici --> Method
 *      - NB: non c'è una sola soluzione che vada bene, è pure soggettivo 
 *
 * VANTAGGI:
 * - Separation of Concerns: L'Enum non contiene logica di business complessa.
 * - Polimorfismo: Possiamo sfruttare l'ereditarietà classica di Java.
 */
public class ExampleDiffWithAbstractFactory {

    /**
     * Enum che agisce da Factory e Registry.
     *
     * Ogni costante dell'Enum viene inizializzata con una istanza specifica
     * della gerarchia 'People'.
     *
     * AVVERTIMENTO IMPORTANTE (SINGLETON):
     * - Le Enum in Java sono Singleton garantiti dalla JVM.
     * - L'istanza 'new European()' passata al costruttore viene creata UNA SOLA VOLTA
     * al caricamento della classe.
     * - Pertanto, l'oggetto restituito da .get() è sempre lo stesso (condiviso).
     * - Questo approccio è ottimo per oggetti Stateless (Strategy), ma pericoloso
     * per oggetti con stato mutabile.
     */
    enum PeopleType {
        EUROPEAN(new European()),
        AFRICAN(new African()),
        ASIAN(new Asian());

        private final People people;

        PeopleType(People people) {
            this.people = people;
        }

        public People get() {
            return people;
        }
    }

    /**
     * Abstract Product.
     * Definisce il contratto per le implementazioni concrete.
     */
    abstract static class People {
        abstract String getName();

        abstract int getSpeed();
    }

    /** Concrete Product 1 */
    static class European extends People {
        String getName() {
            return "Aldo";
        }

        int getSpeed() {
            return 1000;
        }
    }

    /** Concrete Product 2 */
    static class African extends People {
        String getName() {
            return "Giovanni";
        }

        int getSpeed() {
            return 99;
        }
    }

    /** Concrete Product 3 */
    static class Asian extends People {
        String getName() {
            return "Giacomo";
        }

        int getSpeed() {
            return 33;
        }
    }

    /**
     * Client code.
     */
    public void main(String[] args) {
        //
        // NOTA BENE: ENUMS ARE SINGLETONS
        // Recuperiamo l'istanza pre-creata associata alla costante.
        People people = PeopleType.AFRICAN.get();

        // respect Open/Closed Principle
        // Il client lavora sull'astrazione 'People', ignorando l'implementazione concreta.
        people.getName();
        people.getSpeed();

        // we can also do
        // Uso di valueOf per ottenere dinamicamente la "factory" corretta da una stringa.
        PeopleType african = PeopleType.valueOf("ASIAN");
    }
}