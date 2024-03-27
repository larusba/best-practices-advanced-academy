import java.util.Arrays;

public class ArrayUtils {

    public int findMaxElement(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int maxElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }

    public int[] reverseArray(int[] array) {
        int[] reversedArray = Arrays.copyOf(array, array.length);
        int left = 0;
        int right = reversedArray.length - 1;

        while (left < right) {
            // Swap elements at indices left and right
            int temp = reversedArray[left];
            reversedArray[left] = reversedArray[right];
            reversedArray[right] = temp;

            // Move indices towards the center
            left++;
            right--;
        }

        return reversedArray;
    }

    public boolean isPalindromeArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /*
        TODO : esempi di false positive and negative:
            se per sbaglio cancello il `array[i] > maxElement`,
                il test sarà verde ma in realtà la funzione sarà buggata

                For testFindMaxElement, a false positive occurs when the expected value is incorrectly set to 8 instead of 10. A false negative occurs when the correct expected value is set to -3.

    For testReverseArray, a false positive occurs when the expected reversed array is set incorrectly to {1, 2, 3, 4, 5} instead of {5, 4, 3, 2, 1}. A false negative occurs when the correct expected reversed array is set to {8, 7, 6, 5, 4, 3, 2, 1}.

    For testIsPalindromeArray, a false positive occurs when the expected value is incorrectly set to false instead of true. A false negative occurs when the correct expected value is set to true.

    These examples illustrate situations where the test expectations are intentionally set incorrectly to demonstrate false positives and false negatives. In real-world scenarios, you'd want to ensure that your tests accurately reflect the expected behavior of your code.

        import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    import java.util.Arrays;

    public class ArrayUtilsTest {

        @Test
        public void testFindMaxElement() {
            ArrayUtils arrayUtils = new ArrayUtils();

            // False Positive: Incorrect expected value
            assertEquals(8, arrayUtils.findMaxElement(new int[]{1, 5, 3, 10, 8}));

            // False Negative: Correct expected value
            assertEquals(-3, arrayUtils.findMaxElement(new int[]{-5, -2, -8, -10, -3}));
        }

        @Test
        public void testReverseArray() {
            ArrayUtils arrayUtils = new ArrayUtils();

            // False Positive: Incorrect expected value
            assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arrayUtils.reverseArray(new int[]{1, 2, 3, 4, 5}));

            // False Negative: Correct expected value
            assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, arrayUtils.reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        }

        @Test
        public void testIsPalindromeArray() {
            ArrayUtils arrayUtils = new ArrayUtils();

            // False Positive: Incorrect expected value
            assertFalse(arrayUtils.isPalindromeArray(new int[]{1, 2, 3, 4, 3, 2, 1}));

            // False Negative: Correct expected value
            assertTrue(arrayUtils.isPalindromeArray(new int[]{1, 2, 3, 4, 5, 6, 7}));
        }

        // Add more tests for edge cases, boundary values, etc.
    }

         */

    /*
        TODO: unit test

        import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    import java.util.Arrays;

    public class ArrayUtilsTest {

        @Test
        public void testFindMaxElement() {
            ArrayUtils arrayUtils = new ArrayUtils();

            // Test with positive integers
            assertEquals(10, arrayUtils.findMaxElement(new int[]{1, 5, 3, 10, 8}));

            // Test with negative integers
            assertEquals(-2, arrayUtils.findMaxElement(new int[]{-5, -2, -8, -10, -3}));

            // Test with mixed positive and negative integers
            assertEquals(15, arrayUtils.findMaxElement(new int[]{-5, 10, -8, 15, -3}));

            // Test with an empty array
            assertThrows(IllegalArgumentException.class, () -> arrayUtils.findMaxElement(new int[]{}));
        }

        @Test
        public void testReverseArray() {
            ArrayUtils arrayUtils = new ArrayUtils();

            // Test with an odd-length array
            assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arrayUtils.reverseArray(new int[]{1, 2, 3, 4, 5}));

            // Test with an even-length array
            assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, arrayUtils.reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));

            // Test with an empty array
            assertArrayEquals(new int[]{}, arrayUtils.reverseArray(new int[]{}));
        }

        @Test
        public void testIsPalindromeArray() {
            ArrayUtils arrayUtils = new ArrayUtils();

            // Test with a palindrome array
            assertTrue(arrayUtils.isPalindromeArray(new int[]{1, 2, 3, 4, 3, 2, 1}));

            // Test with a non-palindrome array
            assertFalse(arrayUtils.isPalindromeArray(new int[]{1, 2, 3, 4, 5, 6, 7}));

            // Test with an empty array
            assertTrue(arrayUtils.isPalindromeArray(new int[]{}));

            // Test with an array of one element
            assertTrue(arrayUtils.isPalindromeArray(new int[]{42}));
        }

        // Add more tests for edge cases, boundary values, etc.
    }

         */
}
