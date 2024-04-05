package refactoring.extract_subclass;

public class MainNew {
    abstract static class JobItem {
        private int quantity;

        protected JobItem(int quantity) {
            this.quantity = quantity;
        }

        public int getTotalPrice() {
            return quantity * getUnitPrice();
        }

        public int getQuantity() {
            return quantity;
        }

        public abstract int getUnitPrice();
    }

    static class PartsItem extends JobItem {
        private int unitPrice;

        public PartsItem(int quantity, int unitPrice) {
            super(quantity);
            this.unitPrice = unitPrice;
        }

        @Override
        public int getUnitPrice() {
            return unitPrice;
        }
    }

    static class LaborItem extends JobItem {
        private Employee employee;

        public LaborItem(int quantity, Employee employee) {
            super(quantity);
            this.employee = employee;
        }

        public Employee getEmployee() {
            return employee;
        }

        @Override
        public int getUnitPrice() {
            return employee.getRate();
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
    JobItem j1 = new LaborItem(5, kent);
    JobItem j2 = new PartsItem(15, 10);
    int total = j1.getTotalPrice() + j2.getTotalPrice();
}
