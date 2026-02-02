package codesmell.feature_envy;

/**
 * SOLUZIONE: Refactoring tramite "Move Method".
 *
 * Abbiamo spostato la logica nella classe che possiede i dati necessari per eseguirla.
 *
 * VANTAGGI:
 * - Alta Coesione: ContactInfo ora è responsabile della formattazione dei propri dati.
 * - Disaccoppiamento: User non deve più conoscere i dettagli interni (città, via, stato)
 * di ContactInfo, ma chiama semplicemente un metodo di alto livello.
 * - Principio "Tell, Don't Ask": Invece di chiedere i dati per elaborarli fuori,
 * diciamo all'oggetto di fare il lavoro per noi.
 */
public class MainAfter {
    static class ContactInfo {
        public String getStreetName() {
            return "1 Medison Square";
        }

        public String getCity() {
            return "NewYork";
        }

        public String getState() {
            return "NY";
        }

        /**
         * REFACTORING APPLICATO.
         * Il metodo è stato spostato qui perché usa solo campi di questa classe.
         */
        public String getFullAddress() {
            String city = getCity();
            String state = getState();
            String streetName = getStreetName();
            return streetName + ";" + city + ";" + state;
        }
    }

    static class User {

        // La classe User rimane focalizzata solo sulle responsabilità dell'utente (es. username)
        public String getUserName() {
            return "Ajeje";
        }
    }
}