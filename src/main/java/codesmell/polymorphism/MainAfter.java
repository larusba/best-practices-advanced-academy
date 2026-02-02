package codesmell.polymorphism;

/**
 * SOLUZIONE: Polimorfismo (Replace Conditional with Polymorphism).
 *
 * Abbiamo trasformato i rami del 'switch' in sottoclassi distinte.
 * È il meccanismo di dispatch dinamico del linguaggio (Java) a decidere
 * quale metodo eseguire, non un controllo manuale.
 *
 * VANTAGGI:
 * - Estendibilità: Per aggiungere un nuovo tipo, basta creare una nuova classe.
 * Non serve toccare il codice esistente (Open/Closed Principle rispettato).
 * - Pulizia: Ogni classe è responsabile solo della propria logica.
 */
public class MainAfter {
    
    /**
     * Classe base astratta.
     * Definisce il contratto (getSpeed) che tutte le varianti devono rispettare.
     */
    abstract static class People {
        // ...
        abstract String getSpeed();
    }

    static class European extends People {
        String getSpeed() {
            return "Aldo";
        }
    }

    static class African extends People {
        String getSpeed() {
            return "Giovanni";
        }
    }

    static class Asian extends People {
        String getSpeed() {
            return "Giacomo";
        }
    }

    /** Most of the time, we could solve it using an Enum Factory Design Pattern See */
    public static void main(String[] args) {
        // Ora istanziamo direttamente il tipo specifico (o usiamo una Factory)
        African object = new African();

        // respect Open/Closed Principle
        // Il client non deve preoccuparsi di quale implementazione sta usando
        object.getSpeed();
    }
}