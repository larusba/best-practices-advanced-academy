import java.util.Arrays;

public class StringUtil {

    public boolean isAnagram(String str1, String str2) {
        // Null check
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }

        // Remove spaces and convert to lowercase for case-insensitive comparison
        String cleanedStr1 = str1.replaceAll("\\s", "").toLowerCase();
        String cleanedStr2 = str2.replaceAll("\\s", "").toLowerCase();

        // Sort characters and check equality
        char[] charArray1 = cleanedStr1.toCharArray();
        char[] charArray2 = cleanedStr2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public String truncateWithEllipsis(String input, int maxLength) {
        // Null check
        if (input == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        // Truncate and append ellipsis if necessary
        if (input.length() > maxLength) {
            return input.substring(0, maxLength - 3) + "...";
        } else {
            return input;
        }
    }

    public int countSubstringOccurrences(String input, String substring) {
        // Null check
        if (input == null || substring == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }

        int count = 0;
        int index = 0;

        while ((index = input.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

    /*
        TODO - unit test da mettere separato

        testIsAnagram covers true positive cases where strings are anagrams, true negative cases where strings are not anagrams, and an edge case with empty strings.
    testTruncateWithEllipsis covers true positive cases where the string is truncated with an ellipsis, true negative cases where the string length is less than or equal to maxLength, and an edge case with an empty string.
    testCountSubstringOccurrences covers true positive cases where the substring occurs multiple times, true negative cases where the substring does not occur, and an edge case with an empty string.

        import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    import java.util.Arrays;

        public class StringUtilTest {

            @Test
            public void testIsAnagram() {
                StringUtil stringUtil = new StringUtil();

                // True Positive: Anagrams
                assertTrue(stringUtil.isAnagram("listen", "silent"));
                assertTrue(stringUtil.isAnagram("rail safety", "fairy tales"));

                // True Negative: Not Anagrams
                assertFalse(stringUtil.isAnagram("hello", "world"));
                assertFalse(stringUtil.isAnagram("abc", "abcd"));

                // Edge Case: Empty strings
                assertTrue(stringUtil.isAnagram("", ""));
            }

            @Test
            public void testTruncateWithEllipsis() {
                StringUtil stringUtil = new StringUtil();

                // True Positive: Truncate with ellipsis
                assertEquals("Hello...", stringUtil.truncateWithEllipsis("Hello, World!", 5));

                // True Negative: String length is less than or equal to maxLength
                assertEquals("Hello, World!", stringUtil.truncateWithEllipsis("Hello, World!", 15));

                // Edge Case: Empty string
                assertEquals("", stringUtil.truncateWithEllipsis("", 5));
            }

            @Test
            public void testCountSubstringOccurrences() {
                StringUtil stringUtil = new StringUtil();

                // True Positive: Count occurrences
                assertEquals(2, stringUtil.countSubstringOccurrences("ababab", "ab"));
                assertEquals(1, stringUtil.countSubstringOccurrences("abcabcabc", "abc"));

                // True Negative: No occurrences
                assertEquals(0, stringUtil.countSubstringOccurrences("xyz", "abc"));

                // Edge Case: Empty string
                assertEquals(0, stringUtil.countSubstringOccurrences("", "abc"));
            }


        }

         */

}
