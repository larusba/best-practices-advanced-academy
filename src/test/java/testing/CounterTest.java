package testing;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class CounterTest {
    
    /**
     * Test wrongly implemented
     * just to see the error handling
     */
    
    @Test 
    void testFailWithAnonymousErrorMessage() {
        Counter bestPractices = new Counter(15);
        
        try {
            bestPractices.checkCounter();
            fail();
        } catch (Exception e) {
            // we can use a dedicated framework --> org.hamcrest.hamcrest-library
            String actual = e.getMessage();
            
            // if it fails, we don't know the current error actual
            assertTrue(actual.contains("Ajeje Brazorf"));
        }
    }
    
    @Test 
    void testFailWithSpecificErrorMessage() {
        Counter bestPractices = new Counter(15);
        
        try {
            bestPractices.checkCounter();
            fail();
        } catch (Exception e) {
            // we can use a dedicated framework --> org.hamcrest.hamcrest-library
            String message = e.getMessage();
            assertThat(message, Matchers.containsString("Ajeje Brazorf"));
        }
    }

    @Test 
    void testFailWithoutErrorMessage() {
        Counter bestPractices = new Counter(3);

        try {
            bestPractices.checkCounter();
            // non-speaking error..
            fail();
        } catch (Exception e) {
            // we can use a dedicated framework --> org.hamcrest.hamcrest-library
            String message = e.getMessage();
            assertThat(message, Matchers.containsString("Ajeje Brazorf"));
        }
    }

    /**
     * Test rightly implemented, but too generic / not-speaking
     */
    @Test
    void testExceptionTooGeneric() {
        Counter bestPractices = new Counter(15);

        try {
            bestPractices.checkCounter();
            fail();
        } catch (Exception e) {
            // 
            //  NB: should be a false positive, e.g. a `RuntimeException("Franco e Ciccio")`
            // 
            assertTrue(e instanceof RuntimeException);
        }
    }
    
    
    /**
     * Test rightly implemented and speaking
     */
    @Test
    void testNoErrorWithLowCounter() {
        // given
        Counter bestPractices = new Counter(3);
        
        // when and then
        // no assertion since is a void
        bestPractices.checkCounter();
    }

    /* speaking error and fail() */
    @Test
    void testShouldFailWithHighCounter() {
        // given
        Counter bestPractices = new Counter(20);

        try {
            // when
            bestPractices.checkCounter();
            fail("should fail due to counter too high");
        } catch (Exception e) {
            // then
            String expected = "Counter is too high!";
            String actual = e.getMessage();
            assertThat(actual, Matchers.containsString(expected));
        }
    }
    
    @Test
    void testIsCounterNegativeIsTrueWithNegativeCounter() {
        // given
        Counter bestPractices = new Counter(-20);

        // when
        boolean actual = bestPractices.isCounterNegative();

        // then
        assertTrue(actual);
    }


    @Test
    void testIsCounterIsFalseWithPositiveCounter() {
        // given
        Counter bestPractices = new Counter(20);

        boolean actual = bestPractices.isCounterNegative();
        assertFalse(actual);
    }

}
