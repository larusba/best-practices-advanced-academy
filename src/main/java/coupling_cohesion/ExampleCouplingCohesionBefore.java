package coupling_cohesion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * In this design, the OriginalFileProcessor class handles both file reading and data processing.
 * This results in low cohesion, as the class is responsible for multiple unrelated tasks, and high
 * coupling, as it directly interacts with file I/O operations.
 */
public class ExampleCouplingCohesionBefore {

    // OriginalFileProcessor.java
    public static class OriginalFileProcessor {
        private List<String> data;

        public OriginalFileProcessor() {
            this.data = new ArrayList<>();
        }

        public void readFromFile(String filePath) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            reader.close();
        }

        public void processData() {
            for (int i = 0; i < data.size(); i++) {
                data.set(i, data.get(i).toUpperCase());
            }
        }

        public void printProcessedData() {
            for (String line : data) {
                System.out.println(line);
            }
        }

        public void main(String[] args) throws IOException {
            OriginalFileProcessor fileProcessor = new OriginalFileProcessor();
            fileProcessor.readFromFile("input.txt");
            fileProcessor.processData();
            fileProcessor.printProcessedData();
        }
    }
}
