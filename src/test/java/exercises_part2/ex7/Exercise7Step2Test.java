package exercises_part2.ex7;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class Exercise7Step2Test {
    @Test
    void shouldExecuteTemplateSteps() {
        // Creo una classe anonima per testare la classe astratta
        Exercise7Step2.DataMiner miner = spy(new Exercise7Step2.DataMiner() {
            protected void extractData() {} // Stub
        });

        miner.mine("data.txt");

        // FALLISCE (RED): I metodi base sono vuoti
        verify(miner).openFile("data.txt");
        verify(miner).analyzeData();
        verify(miner).closeFile();
    }
}