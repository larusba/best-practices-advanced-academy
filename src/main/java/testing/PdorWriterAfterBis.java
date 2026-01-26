package testing;

/**
 * Immutable value object version of the original Exercise class.
 *
 * This implementation improves the original design by:
 * - Replacing mutable state and setters with an immutable data structure
 * - Ensuring the object is always valid after construction
 * - Modeling the concept of "number of Pdor" explicitly as a domain value
 * - Encapsulating validation logic in the constructor
 * - Providing stronger type safety than using a raw integer
 *
 * This approach is ideal when the value represents a meaningful concept
 * in the domain and should not be freely mutable.
 */
public record PdorWriterAfterBis(int times) {

    public static final String PDOR = "Pdor!";
    public static final int MAX_PDORS = 20;

    public PdorWriterAfterBis {
        if (times < 0 || times > MAX_PDORS) {
            throw new IllegalArgumentException(
                "times must be between 0 and " + MAX_PDORS
            );
        }
    }

    public String asString() {
        return PDOR.repeat(times);
    }
}
