package codesmell.feature_envy;

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
         * Feature envy: questo metodo implementa solo metodi riguardanti il PARAMETRO ContactInfo
         * Simile al Middle Man, ma non riguarda i field
         */
        public String getFullAddress(ContactInfo info) {
            String city = info.getCity();
            String state = info.getState();
            String streetName = info.getStreetName();
            return streetName + ";" + city + ";" + state;
        }
    }
}
