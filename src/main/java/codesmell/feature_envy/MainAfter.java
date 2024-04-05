package codesmell.feature_envy;

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

        /** Metodo spostato qui */
        public String getFullAddress() {
            String city = getCity();
            String state = getState();
            String streetName = getStreetName();
            return streetName + ";" + city + ";" + state;
        }
    }

    static class User {

        // rimangono solo cose riguandanti `User`
        public String getUserName() {
            return "Ajeje";
        }
    }
}
