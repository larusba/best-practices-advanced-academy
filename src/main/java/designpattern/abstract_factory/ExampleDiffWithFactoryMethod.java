package designpattern.abstract_factory;

/**
 * Alternativa semplificata ai pattern Factory/Strategy usando le Enum.
 *
 * CONFRONTO DIDATTICO:
 * Mentre l'Abstract Factory usa molte classi per la massima flessibilità,
 * Java permette di usare le Enum per ottenere un risultato simile con molto meno codice
 * quando il numero di varianti è fisso e limitato.
 *
 * VANTAGGI:
 * - Compattezza: Dati e comportamento sono in un unico file.
 * - Sicurezza: Impossibile creare istanze non valide (Singleton garantito dalla JVM).
 * - Meno boilerplate: Niente interfacce vuote o factory multiple.
 */
public class ExampleDiffWithFactoryMethod {

    /**
     * "Smart Enum" (Enum Intelligente).
     *
     * Qui l'Enum non è solo una lista di etichette, ma gestisce stato e comportamento.
     * Agisce contemporaneamente da:
     * - Factory: Fornisce l'istanza corretta (es. PeopleType.AFRICAN).
     * - Data Holder: Contiene i dati specifici (name, speed) senza bisogno di sottoclassi separate.
     */
    enum PeopleType {
        EUROPEAN("Aldo", 1000),
        AFRICAN("Giovanni", 99),
        ASIAN("Giacomo", 33);

        private final String name;
        private final int speed;

        PeopleType(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }
    }

    /**
     * Esempio di utilizzo del pattern "Enum Factory".
     */
    public void main(String[] args) {
        // Creazione implicita e thread-safe gestita dalla JVM
        PeopleType people = PeopleType.AFRICAN;

        // Utilizzo dei dati incapsulati
        // Rispetta il principio di incapsulamento, ma "chiude" un po' l'estendibilità
        // (per aggiungere un tipo bisogna ricompilare l'Enum).
        people.getName();
        people.getSpeed();

        // Factory Method integrato: valueOf converte stringa in istanza
        // Utile per deserializzazione o input utente
        PeopleType african = PeopleType.valueOf("AFRICAN");
    }
}