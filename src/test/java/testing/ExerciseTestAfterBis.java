package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ExerciseTestAfterBis {
    /**
     * EX 1 + EX 2 + EX 3 (parte positiva)
     *
     * Verifica che Pdor.repeat() ritorni la stringa corretta
     * in base al numero di ripetizioni.
     */
    @ParameterizedTest
    @CsvSource({
            "1, Pdor!",
            "5, Pdor!Pdor!Pdor!Pdor!Pdor!",
            "0, ''"
    })
    public void testRepeatValidTimes(int times, String expected) {
        // WHEN
        String result = Pdor.repeat(times);

        // THEN
        assertEquals(expected, result);
    }

    /**
     * EX 3 (parte negativa)
     *
     * Verifica che valori non validi lancino IllegalArgumentException
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 21, 999})
    public void testRepeatInvalidTimes(int times) {
        assertThrows(IllegalArgumentException.class, () -> Pdor.repeat(times));
    }
}
