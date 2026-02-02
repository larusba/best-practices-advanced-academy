package intro.liskov;

/**
 * the superclass Vehicle contains a method startEngine() to start the engine of the vehicle, but it
 * does not make any assumptions about the specific behavior of starting the engine for different
 * types of vehicles. Each subclass (Car and Motorcycle) overrides the startEngine() method to
 * provide its specific implementation. This ensures that the code adheres to the Liskov
 * Substitution Principle, as substituting a Car or Motorcycle object for a Vehicle object does not
 * change the expected behavior of the program.
 */
public class MainAfter {

    // 1. Classe Base GENERICA
    // Definisce solo ciò che ogni veicolo può fare: muoversi.
    static abstract class Vehicle {
        public void move() {
            System.out.println("The vehicle is moving...");
        }
    }

    // 2. Classe Intermedia per VEICOLI A MOTORE
    // Qui introduciamo il concetto di motore e carburante.
    static abstract class MotorVehicle extends Vehicle {
        private String fuelType;

        public MotorVehicle(String fuelType) {
            this.fuelType = fuelType;
        }

        public void startEngine() {
            System.out.println("Starting engine (" + fuelType + ")...");
        }
    }

    // 3. Classe Intermedia per VEICOLI SENZA MOTORE (Opzionale, per chiarezza)
    static abstract class ManualVehicle extends Vehicle {
        public void pedaling() {
            System.out.println("Pedaling...");
        }
    }

    // --- IMPLEMENTAZIONI CONCRETE ---

    // Car è un MotorVehicle -> Ha il metodo startEngine
    static class Car extends MotorVehicle {
        public Car(String fuelType) {
            super(fuelType);
        }

        @Override
        public void startEngine() {
            System.out.println("Vroom! Car engine started with " + super.fuelType);
        }
    }

    // Bicycle è un ManualVehicle (o direttamente Vehicle) -> NON HA startEngine
    static class Bicycle extends ManualVehicle {
        @Override
        public void move() {
            System.out.println("The bicycle is moving silently.");
        }
    }

    // --- MAIN ---
    
    public static class Main {
        public static void main(String[] args) {
            
            // Caso 1: Trattiamo tutto come Veicolo generico
            Vehicle myBike = new Bicycle();
            Vehicle myCar = new Car("Diesel");

            myBike.move(); // Ok
            myCar.move();  // Ok
            
            // myBike.startEngine(); // ERRORE DI COMPILAZIONE! 
            // Il compilatore ci impedisce di chiamare startEngine su un Vehicle generico.
            // LSP è salvo: non possiamo chiamare un metodo che non esiste per tutti.

            // Caso 2: Usiamo la classe specifica per i motori
            MotorVehicle myMoto = new Car("Gasoline");
            startTrip(myMoto); // Funziona solo con veicoli a motore
        }

        // Questo metodo accetta solo veicoli che rispettano il contratto "hanno un motore"
        public static void startTrip(MotorVehicle v) {
            v.startEngine();
            v.move();
        }
    }
}