package refactoring.replace_method_with_method_object;

public class MainAfter {
    class Account {
        private final int delta;

        public Account(int delta) {
            this.delta = delta;
        }

        public int getDelta() {
            return delta;
        }

        /** Long method extracted */
        int gamma(int inputVal, int quantity, int yearToDate) {
            return new Gamma(this, inputVal, quantity, yearToDate).compute();
        }
    }

    /** All local vars are now fields, e.g. importantValue1 */
    class Gamma {
        private final Account account;
        private int importantValue1;
        private int importantValue2;
        private int importantValue3;
        private int inputVal;
        private int quantity;
        private int yearToDate;

        public Gamma(Account source, int inputValArg, int quantityArg, int yearToDateArg) {
            this.account = source;
            inputVal = inputValArg;
            quantity = quantityArg;
            yearToDate = yearToDateArg;
        }

        public int compute() {
            importantValue1 = (inputVal * quantity) + account.getDelta();
            importantValue2 = (inputVal * yearToDate) + 100;
            importantThing();
            importantValue3 = importantValue2 * 7;
            // and so on…
            return importantValue3 - 2 * importantValue1;
        }

        void importantThing() {
            if ((yearToDate - importantValue1) > 100) {
                importantValue2 -= 20;
            }
        }
    }
}
