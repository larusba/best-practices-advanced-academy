package testing;


/**
 * TODO - durante la demo usare il refactoring > rename in `Counter` 
 */
public class Counter {
    
    private final int counter;

    public Counter(int counter) {
        this.counter = counter;
    }

    public boolean isCounterNegative() {
        return counter < 0;
    }
    
    public void checkCounter() {
        if (counter > 10) {
            throw new RuntimeException("Counter is too high!");
        }
    }
}

