public class StringUtilsTwo {

    public String reverseString(String input) {
        if (input == null) {
            throw new NullPointerException("Input string cannot be null");
        }

        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input) {
        if (input == null) {
            throw new NullPointerException("Input string cannot be null");
        }

        String reversed = reverseString(input);
        return input.equals(reversed);
    }

    public String getMiddleCharacter(String input) {
        if (input == null) {
            throw new NullPointerException("Input string cannot be null");
        }

        int length = input.length();
        if (length == 0) {
            return "";
        }

        int middleIndex = length / 2;
        if (length % 2 == 0) {
            // Even length, return two middle characters
            return input.substring(middleIndex - 1, middleIndex + 1);
        } else {
            // Odd length, return the middle character
            return input.substring(middleIndex, middleIndex + 1);
        }
    }

    /*
        TODO - unit test da mettere separato


        import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

        public class StringUtilsTest {

            @Test
            public void testReverseString() {
                StringUtils utils = new StringUtils();
                assertEquals("tac", utils.reverseString("cat"));
                assertEquals("racecar", utils.reverseString("racecar"));
                assertEquals("", utils.reverseString(""));
            }

            @Test
            public void testIsPalindrome() {
                StringUtils utils = new StringUtils();
                assertTrue(utils.isPalindrome("radar"));
                assertTrue(utils.isPalindrome("level"));
                assertFalse(utils.isPalindrome("hello"));
                assertTrue(utils.isPalindrome(""));
            }

            @Test
            public void testGetMiddleCharacter() {
                StringUtils utils = new StringUtils();
                assertEquals("c", utils.getMiddleCharacter("abc"));
                assertEquals("es", utils.getMiddleCharacter("test"));
                assertEquals("", utils.getMiddleCharacter(""));
                assertEquals("a", utils.getMiddleCharacter("a"));
            }

            @Test
            public void testEdgeCases() {
                StringUtils utils = new StringUtils();

                // Test null input for reverseString
                assertThrows(NullPointerException.class, () -> utils.reverseString(null));

                // Test null input for isPalindrome
                assertThrows(NullPointerException.class, () -> utils.isPalindrome(null));

                // Test null input for getMiddleCharacter
                assertThrows(NullPointerException.class, () -> utils.getMiddleCharacter(null));
            }


        }

         */

}
