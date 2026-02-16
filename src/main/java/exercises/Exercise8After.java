package exercises;

/**
 * Builder Pattern:
 * Permette di costruire oggetti complessi passo dopo passo in modo leggibile,
 * eliminando la necessità di costruttori giganti o parametri nulli.
 */
public class Exercise8After {

    public static class User {
        private final String firstName;
        private final String lastName;
        private final int age;
        private final String phone;
        private final String address;

        // Il costruttore è privato per forzare l'uso del Builder
        private User(UserBuilder builder) {
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.age = builder.age;
            this.phone = builder.phone;
            this.address = builder.address;
        }

        // Getter...

        @Override
        public String toString() {
            return firstName + " " + lastName + " (Età: " + age + ", Tel: " + phone + ")";
        }

        // Static Builder Class
        public static class UserBuilder {
            private String firstName; // Obbligatorio
            private String lastName;  // Obbligatorio
            private int age;          // Opzionale
            private String phone;     // Opzionale
            private String address;   // Opzionale

            public UserBuilder(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public UserBuilder age(int age) {
                this.age = age;
                return this;
            }

            public UserBuilder phone(String phone) {
                this.phone = phone;
                return this;
            }

            public UserBuilder address(String address) {
                this.address = address;
                return this;
            }

            public User build() {
                return new User(this);
            }
        }
    }

    public static void main(String[] args) {
        // Molto più leggibile e flessibile
        User user = new User.UserBuilder("Mario", "Rossi")
                .age(30)
                .address("Via Roma 1")
                // Non serve passare null per il telefono
                .build();

        System.out.println(user);
    }
}