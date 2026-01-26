package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExerciseTestAfter {
    /**
     * EX 1
     *
     * Verifica che Pdor.repeat(1) ritorni "Pdor!"
     */
    @Test
    public void testRepeatOnce() {
        String result = Pdor.repeat(1);
        assertEquals("Pdor!", result);
    }

    /**
     * EX 2
     *
     * Verifica che Pdor.repeat(5) ritorni "Pdor!" ripetuta 5 volte
     */
    @Test
    public void testRepeatFiveTimes() {
        String result = Pdor.repeat(5);
        assertEquals("Pdor!Pdor!Pdor!Pdor!Pdor!", result);
    }

    /**
     * EX 3 (caso positivo)
     *
     * Verifica che Pdor.repeat(0) ritorni stringa vuota
     */
    @Test
    public void testRepeatZeroTimes() {
        String result = Pdor.repeat(0);
        assertEquals("", result);
    }

    /**
     * EX 3 (caso negativo)
     *
     * Verifica che Pdor.repeat(-1) lanci IllegalArgumentException
     */
    @Test
    public void testRepeatNegativeTimesThrows() {
        assertThrows(IllegalArgumentException.class, () -> Pdor.repeat(-1));
    }

    /**
     * EX 3 (caso negativo)
     *
     * Verifica che Pdor.repeat(21) lanci IllegalArgumentException
     */
    @Test
    public void testRepeatTooManyTimesThrows() {
        assertThrows(IllegalArgumentException.class, () -> Pdor.repeat(21));
    }
}
