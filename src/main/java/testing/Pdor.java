package testing;

/**
 * Functional utility version of the original Exercise class.
 *
 * This class improves upon the original implementation by:
 * - Eliminating mutable state (no fields, no setters)
 * - Providing a pure function (same input -> same output)
 * - Making side effects explicit by returning a value instead of writing to I/O
 * - Being easier to test, reason about, and reuse
 * - Avoiding object lifecycle concerns entirely
 *
 * This design is preferable when no domain identity is required and
 * the logic can be expressed as a deterministic transformation.
 */
public final class Pdor {

    public static final String PDOR = "Pdor!";
    public static final int MAX_PDORS = 20;

    private Pdor() {
        // utility class
    }

    public static String repeat(int times) {
        validate(times);
        return PDOR.repeat(times);
    }

    private static void validate(int times) {
        if (times < 0 || times > MAX_PDORS) {
            throw new IllegalArgumentException(
                "times must be between 0 and " + MAX_PDORS
            );
        }
    }
}
