package codesmell.feature_envy;

/**
 * CODE SMELL: Feature Envy (Invidia delle Caratteristiche).
 *
 * Questo codice viola il principio "Keep data and behavior together" (Tieni dati e comportamento insieme).
 *
 * PROBLEMA:
 * - La classe User contiene un metodo (getFullAddress) che si interessa
 * esclusivamente ai dati di un'altra classe (ContactInfo).
 * - User non usa nessuno dei propri campi per calcolare l'indirizzo.
 * - Questo aumenta l'accoppiamento: se la struttura interna di ContactInfo cambia,
 * siamo costretti a modificare la classe User.
 */
public class MainBefore {

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
    }

    static class User {

        public String getUserName() {
            return "Ajeje";
        }

        /**
         * ESEMPIO DI FEATURE ENVY.
         *
         * Questo metodo accede ripetutamente ai getter dell'oggetto ContactInfo
         * per elaborare un risultato. È un chiaro segnale che questa logica
         * dovrebbe appartenere alla classe ContactInfo, non a User.
         */
        public String getFullAddress(ContactInfo info) {
            String city = info.getCity();
            String state = info.getState();
            String streetName = info.getStreetName();
            return streetName + ";" + city + ";" + state;
        }
    }
}