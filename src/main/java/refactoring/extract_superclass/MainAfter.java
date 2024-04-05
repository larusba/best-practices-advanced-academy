package refactoring.extract_superclass;

import java.util.List;

public class MainAfter {
    /** Class with identical fields: name, surname */
    abstract static class CompanyElement {
        protected final String name;
        protected final String surname;

        protected CompanyElement(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public abstract int getAnnualCost();
    }

    static class Employee extends CompanyElement {
        private final int annualCost;
        private final String id;

        public Employee(String name, String surname, String id, int annualCost) {
            super(name, surname);
            this.id = id;
            this.annualCost = annualCost;
        }

        @Override
        public int getAnnualCost() {
            return annualCost;
        }

        public String getId() {
            return id;
        }
    }

    static class Department extends CompanyElement {
        private final List<CompanyElement> staff;

        public Department(String name, String surname, List<CompanyElement> staff) {
            super(name, surname);
            this.staff = staff;
        }

        @Override
        public int getAnnualCost() {
            return staff.stream().mapToInt(CompanyElement::getAnnualCost).sum();
        }

        public int getHeadCount() {
            return staff.size();
        }
    }
}
