package exercises;

/**
 * ESERCIZIO: Rifattorizza la creazione dell'oggetto.
 * Il costruttore è confuso, difficile da leggere e richiede di passare 'null' per i campi opzionali.
 */
public class Exercise8Before {

    public static class User {
        private String firstName; // Obbligatorio
        private String lastName;  // Obbligatorio
        private int age;          // Opzionale
        private String phone;     // Opzionale
        private String address;   // Opzionale

        public User(String firstName, String lastName, int age, String phone, String address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.phone = phone;
            this.address = address;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + " (Età: " + age + ", Tel: " + phone + ")";
        }
    }

    public static void main(String[] args) {
        // È difficile capire cosa sono questi parametri senza guardare la classe
        User user = new User("Mario", "Rossi", 30, null, "Via Roma 1");
        System.out.println(user);
    }
}