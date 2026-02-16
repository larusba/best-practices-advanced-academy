package exercises;

/**
 * ESERCIZIO: Pulisci la firma e la logica di questo metodo.
 */
public class Exercise12Before {

    // Il parametro booleano 'isUrgent' cambia drasticamente il comportamento del metodo
    public void sendEmail(String message, boolean isUrgent) {
        if (isUrgent) {
            System.out.println("Sending HIGH PRIORITY email: " + message);
            System.out.println("Adding read receipt...");
            System.out.println("Notifying admin via SMS...");
        } else {
            System.out.println("Sending standard email: " + message);
        }
    }
}
