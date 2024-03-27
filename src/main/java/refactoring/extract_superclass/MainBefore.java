package refactoring.extract_superclass;

import java.util.List;

public class MainBefore {
    static class Employee {
        private final String name;
        private final String surname;
        private final int annualCost;
        private final String id;

        public Employee(String name, String surname, String id, int annualCost) {
            this.name = name;
            this.surname = surname;
            this.id = id;
            this.annualCost = annualCost;
        }
        public int getAnnualCost() {
            return annualCost;
        }
        public String getId() {
            return id;
        }
        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }
    }

    /**
     * The department has a list of Employee
     */
    static class Department {
        private final String name;
        private final String surname;
        private final List<Employee> staff;

        public Department(String name, String surname, List<Employee> staff) {
            this.name = name;
            this.surname = surname;
            this.staff = staff;
        }

        /**
         * sum of employees annualCosts
         */
        public int getTotalAnnualCost() {
            return staff.stream()
                    .mapToInt(Employee::getAnnualCost)
                    .sum();
        }
        
        public int getHeadCount() {
            return staff.size();
        }
        
        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }
        // other stuff...
    }
}
