package exercises;

/**
 * **Parameter Object** (o Value Object) chiamato `ConnectionConfig`.
 * Questo elimina la "Primitive Obsession" e i "Data Clumps", centralizzando la validazione dei dati (es. porta valida).
 * NB: record è disponibile da java 16+
 */
public class Exercise13After {

    /*
    NB: java 16: record invece di class:
    con le versioni precedenti dovremmo mettere class come sotto:
    
     */
    public record ConnectionConfig(String ip, int port, String user, String password) {
        public ConnectionConfig {
            if (port < 0 || port > 65535) throw new IllegalArgumentException("Invalid port");
        }
    }

    /*
    public class ConnectionConfig {
        // 1. Campi final (rendono la classe immutabile come un record)
        private final String ip;
        private final int port;
        private final String user;
        private final String password;

        // 2. Costruttore con validazione
        public ConnectionConfig(String ip, int port, String user, String password) {
            if (port < 0 || port > 65535) {
                throw new IllegalArgumentException("Invalid port");
            }
            this.ip = ip;
            this.port = port;
            this.user = user;
            this.password = password;
        }

        // 3. Getters (nei record si chiamano ip(), nelle classi solitamente getIp())
        public String getIp() {
            return ip;
        }

        public int getPort() {
            return port;
        }

        public String getUser() {
            return user;
        }

        public String getPassword() {
            return password;
        }
    }
    */
    
    public void createServerConnection(ConnectionConfig config) {
        System.out.println("Connecting to " + config.ip() + ":" + config.port() + " as " + config.user());
    }

    public void testConnection(ConnectionConfig config) {
        System.out.println("Testing ping for " + config.ip());
    }
}