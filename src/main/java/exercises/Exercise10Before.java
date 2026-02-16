package exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ESERCIZIO: Migliora la robustezza e la gestione degli errori di questo metodo.
 */
public class Exercise10Before {

    public String loadConfig(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Ritorna null in caso di errore
        }
    }

    public void startApp() {
        String config = loadConfig("config.txt");
        // Qui esploderà con un NullPointerException se il file non esiste
        System.out.println("Config loaded: " + config.length());
    }
}