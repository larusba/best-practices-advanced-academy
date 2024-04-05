package refactoring.extract_subclass;

public class MainOld {
    static class JobItem {
        private int quantity;
        private int unitPrice;
        private Employee employee;
        private boolean isLabor;

        public JobItem(int quantity, int unitPrice, boolean isLabor, Employee employee) {
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.isLabor = isLabor;
            this.employee = employee;
        }

        public int getTotalPrice() {
            return quantity * getUnitPrice();
        }

        public int getQuantity() {
            return quantity;
        }

        /**
         * The method depends on isLabor, and `employee` makes sense only with isLabor=true we could
         * create 2 classes starting from an abstract class
         */
        public int getUnitPrice() {
            return (isLabor) ? employee.getRate() : unitPrice;
        }

        public Employee getEmployee() {
            return employee;
        }
    }

    static class Employee {
        private int rate;

        public Employee(int rate) {
            this.rate = rate;
        }

        public int getRate() {
            return rate;
        }
    }

    // Somewhere in client code
    Employee kent = new Employee(50);
    JobItem j1 = new JobItem(5, 0, true, kent);
    JobItem j2 = new JobItem(15, 10, false, null);
    int total = j1.getTotalPrice() + j2.getTotalPrice();
}
