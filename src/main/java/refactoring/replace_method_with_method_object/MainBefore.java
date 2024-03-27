package refactoring.replace_method_with_method_object;

public class MainBefore {
    class Account {
        private final int delta;

        public Account(int delta) {
            this.delta = delta;
        }

        public int getDelta() {
            return delta;
        }

        /**
         * Long method... we could extract it
         */
        int gamma(int inputVal, int quantity, int yearToDate) {
            int importantValue1 = (inputVal * quantity) + getDelta();
            int importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
            int importantValue3 = importantValue2 * 7;
            // and so on…
            return importantValue3 - 2 * importantValue1;
        }
        // ...
    }
}
