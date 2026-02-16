package exercises;

/**
 * ESERCIZIO: Rifattorizza per migliorare la struttura dei parametri.
 */
public class Exercise13Before {

    // Questi 4 parametri viaggiano sempre insieme
    public void createServerConnection(String ip, int port, String user, String password) {
        if (port < 0 || port > 65535) throw new IllegalArgumentException("Invalid port");
        System.out.println("Connecting to " + ip + ":" + port + " as " + user);
    }

    public void testConnection(String ip, int port, String user, String password) {
        System.out.println("Testing ping for " + ip);
    }
}