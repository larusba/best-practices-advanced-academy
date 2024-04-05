package exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Signature {
    // Good Practice: Proper Exception Handling
    public static class FileReaderOne {

        // Good Practice: Using a Descriptive Method Signature
        public String readContent(String path) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString();
            } catch (IOException e) {
                throw new IOException("Error reading file: " + path, e);
            }
        }
    }
    
    

    // Poor Practice: Improper Exception Handling
    public static class FileReaderTwo {

        // Poor Practice: Non-Descriptive Method Signature
        public String readFile(String path) throws Exception {
            
            final var test = 0;
            
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString();
            }
        }
    }
}
