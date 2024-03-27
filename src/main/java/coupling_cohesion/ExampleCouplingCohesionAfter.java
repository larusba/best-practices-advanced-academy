package coupling_cohesion;

// FileDataReader.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Now, let's refactor the code to improve cohesion and reduce coupling by separating file
 * operations and data processing into distinct classes.
 *
 * <p>In this refactoring:
 *
 * <p>FileDataReader is responsible for reading data from a file, improving cohesion by
 * encapsulating file-related operations. DataProcessor is responsible for processing and printing
 * data, further improving cohesion by focusing on data-related operations. FileProcessingApp
 * demonstrates how the two classes can be used independently, reducing coupling as they are no
 * longer tightly integrated into a single class. This refactoring promotes a more modular and
 * maintainable design by adhering to the principles of high cohesion and low coupling.
 *
 * <p>This refactoring promotes a more modular and maintainable design by adhering to the principles
 * of high cohesion and low coupling.
 */
public class ExampleCouplingCohesionAfter {

    public static class FileDataReader {
        public List<String> readFromFile(String filePath) throws IOException {
            List<String> data = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            reader.close();
            return data;
        }
    }

    // DataProcessor.java
    public static class DataProcessor {
        public void processData(List<String> data) {
            for (int i = 0; i < data.size(); i++) {
                data.set(i, data.get(i).toUpperCase());
            }
        }

        public void printProcessedData(List<String> data) {
            for (String line : data) {
                System.out.println(line);
            }
        }
    }

    // FileProcessingApp.java
    public static class FileProcessingApp {
        public static void main(String[] args) throws IOException {
            FileDataReader fileDataReader = new FileDataReader();
            DataProcessor dataProcessor = new DataProcessor();

            List<String> data = fileDataReader.readFromFile("input.txt");
            dataProcessor.processData(data);
            dataProcessor.printProcessedData(data);
        }
    }
}
