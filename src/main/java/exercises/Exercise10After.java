package exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * L'eccezione non viene più "ingoiata" restituendo null. Viene lanciata una **Custom Runtime Exception**.
 * Questo impedisce che l'applicazione continui in uno stato inconsistente e obbliga chi chiama il metodo a gestire il problema.
 */
public class Exercise10After {

    public static class ConfigurationException extends RuntimeException {
        public ConfigurationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public String loadConfig(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new ConfigurationException("Impossibile caricare la configurazione dal percorso: " + path, e);
        }
    }

    public void startApp() {
        try {
            String config = loadConfig("config.txt");
            System.out.println("Config loaded: " + config.length());
        } catch (ConfigurationException e) {
            System.err.println("Errore critico all'avvio: " + e.getMessage());
        }
    }
}