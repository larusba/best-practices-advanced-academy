
package exercises;

/**
 * Il metodo è stato diviso (**Split Method**) rimuovendo il parametro "flag" booleano.
 * Ora esistono due metodi espliciti (`sendStandardEmail` e `sendUrgentEmail`) che chiariscono l'intento senza ambiguità.
 */
public class Exercise12After {

    public void sendStandardEmail(String message) {
        System.out.println("Sending standard email: " + message);
    }

    public void sendUrgentEmail(String message) {
        System.out.println("Sending HIGH PRIORITY email: " + message);
        addReadReceipt();
        notifyAdmin();
    }

    private void addReadReceipt() { System.out.println("Adding read receipt..."); }
    private void notifyAdmin() { System.out.println("Notifying admin via SMS..."); }
}