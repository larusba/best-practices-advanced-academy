package designpattern.abstract_factory;

/**
 * Esempio del Design Pattern Abstract Factory.
 *
 * Questo pattern fornisce un'interfaccia per creare famiglie di oggetti correlati
 * o dipendenti senza specificare le loro classi concrete.
 *
 * Concetti chiave:
 * - Famiglia di Prodotti: Un set di oggetti che devono lavorare insieme (es. EmberCPU va solo con EmberMMU).
 * - Coerenza: Il pattern garantisce che il client non possa mischiare inavvertitamente
 * prodotti di famiglie diverse (es. CPU Enginola con MMU Ember).
 */
public class Main {
    /**
     * COMPONENT: Abstract Product (Tipo A)
     * Definisce l'interfaccia per un tipo di prodotto (CPU).
     */
    abstract static class CPU {}

    /**
     * COMPONENT: Concrete Product (Tipo A, Famiglia 1)
     * Implementazione specifica della CPU per l'architettura Ember.
     */
    static class EmberCPU extends CPU {}

    /**
     * COMPONENT: Concrete Product (Tipo A, Famiglia 2)
     * Implementazione specifica della CPU per l'architettura Enginola.
     */
    static class EnginolaCPU extends CPU {}

    /**
     * COMPONENT: Abstract Product (Tipo B)
     * Definisce l'interfaccia per un altro tipo di prodotto (Memory Management Unit).
     */
    abstract static class MMU {}

    /**
     * COMPONENT: Concrete Product (Tipo B, Famiglia 1)
     */
    static class EmberMMU extends MMU {}

    /**
     * COMPONENT: Concrete Product (Tipo B, Famiglia 2)
     */
    static class EnginolaMMU extends MMU {}

    /**
     * COMPONENT: Concrete Factory (Famiglia 1 - Ember)
     *
     * Questa factory sa come creare l'intera suite di prodotti per l'architettura Ember.
     * Garantisce che se chiedi una CPU e una MMU, siano entrambe "Ember".
     */
    static class EmberToolkit extends AbstractFactory {
        @Override
        public CPU createCPU() {
            return new EmberCPU();
        }

        @Override
        public MMU createMMU() {
            return new EmberMMU();
        }
    }

    /**
     * COMPONENT: Concrete Factory (Famiglia 2 - Enginola)
     */
    static class EnginolaToolkit extends AbstractFactory {
        @Override
        public CPU createCPU() {
            return new EnginolaCPU();
        }

        @Override
        public MMU createMMU() {
            return new EnginolaMMU();
        }
    }

    enum Architecture {
        ENGINOLA,
        EMBER
    }

    /**
     * COMPONENT: Abstract Factory
     *
     * Definisce i metodi di creazione per tutti i prodotti della famiglia (CPU, MMU).
     * Il client userà solo questa interfaccia, ignorando le factory concrete.
     */
    abstract static class AbstractFactory {
        // Singleton/Cache delle factory concrete
        private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
        private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

        /**
         * Metodo statico (spesso chiamato Factory Producer o configuratore)
         * che restituisce la Factory corretta in base a una configurazione.
         *
         * @param architecture L'architettura desiderata.
         * @return La ConcreteFactory specifica per quella architettura.
         */
        static AbstractFactory getFactory(Architecture architecture) {
            AbstractFactory factory = null;
            switch (architecture) {
                case ENGINOLA:
                    factory = ENGINOLA_TOOLKIT;
                    break;
                case EMBER:
                    factory = EMBER_TOOLKIT;
                    break;
            }
            return factory;
        }

        public abstract CPU createCPU();

        public abstract MMU createMMU();
    }

    public static class Client {
        public static void main(String[] args) {
            // 1. Configurazione: Il client sceglie l'architettura (o la legge da file di config)
            // Ottiene la factory specifica, ma la tratta come AbstractFactory generica.
            AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);

            // 2. Creazione: Il client crea i prodotti.
            // NOTA: Il client NON sa che sta creando una 'EmberCPU'.
            // Sa solo che sta ricevendo una 'CPU' compatibile con la factory scelta.
            CPU cpu = factory.createCPU();
            
            // Se creassimo anche una MMU qui, saremmo sicuri al 100% che è compatibile con la CPU.
            MMU mmu = factory.createMMU();
        }
    }
}