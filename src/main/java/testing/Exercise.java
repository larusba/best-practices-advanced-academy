package testing;


import java.io.StringWriter;

/**
 * Simple class that says "Pdor!".
 */
public class Exercise {

    public static final String PDOR = "Pdor!";

    public static final int MAXIMUM_AMOUNT_OF_PDORS = 20;

    private int times = 1;

    /**
     * Set how many times "Pdor!" should be said.
     */
    public void setTimes(int times) {
        if (times < 0 || times > MAXIMUM_AMOUNT_OF_PDORS) {
            throw new IllegalArgumentException(String.format(
                    "Parameter «times» should be a positive number no larger than %d.",
                    MAXIMUM_AMOUNT_OF_PDORS
            ));
        }
        this.times = times;
    }

    /**
     * Say "Pdor!".
     *
     */
    public void sayPdor(StringWriter printer) {
        for (short i = 0; i < times; i++) {
            printer.write(PDOR);
        }
    }

}