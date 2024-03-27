package refactoring.parallelinheritence;

public class MainNew {
    public static class PartialComputerEngineer implements Engineer, MileStone {

        private String type;
        private int salary;

        @Override
        public String work() {
            return"Build a Billing MicroService";
        }

        @Override
        public String target() {
            return "Has to be finshed in 14 PD";
        }

        @Override
        public String getType() {
            // TODO Auto-generated method stub
            return type;
        }

        @Override
        public void setType(String type) {
            this.type=type;
        }

        @Override
        public int getSalary() {
            // TODO Auto-generated method stub
            return salary;
        }

        @Override
        public void setSalary(int salary) {
            this.salary=salary;
        }

        @Override
        public MileStone getMileStone() {
            // TODO Auto-generated method stub
            return this;
        }

        @Override
        public void setMileStone(MileStone mileStone) {
            throw new UnsupportedOperationException("Not Supported");
        }

        @Override
        public String toString() {
            return "PartialComputerEngineer [type=" + type + ", salary=" + salary
                   + ", work()=" + work() + ", target()=" + target()
                   + ", getType()=" + getType() + ", getSalary()=" + getSalary()
                   + "]";
        }
    }


    public static class PartialCivilEngineer implements Engineer,MileStone {
        private String type;
        private int salary;

        @Override
        public String work() {
            return "Create  Twin Towers";
        }

        @Override
        public String target() {
            return "Has to be completed in 2 years";
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public void setType(String type) {
            this.type=type;
        }

        @Override
        public int getSalary() {
            // TODO Auto-generated method stub
            return salary;
        }

        @Override
        public void setSalary(int salary) {
            this.salary=salary;
        }

        @Override
        public MileStone getMileStone() {
            // TODO Auto-generated method stub
            return this;
        }

        @Override
        public void setMileStone(MileStone mileStone) {
            throw new UnsupportedOperationException("Not Supported");
        }

        @Override
        public String toString() {
            return "PartialCivilEngineer [type=" + type + ", salary=" + salary
                   + ", work()=" + work() + ", target()=" + target()
                   + ", getType()=" + getType() + ", getSalary()=" + getSalary()
                   + "]";
        }
    }
    
    
    public static void main(String[] args) {
        Engineer comp = new PartialComputerEngineer();
        comp.setType("Computer Engineer");
        comp.setSalary(50000);

        Engineer civil = new PartialCivilEngineer();
        civil.setType("Computer Engineer");
        civil.setSalary(50000);

        System.out.println(comp);
        System.out.println("********************");
        System.out.println(civil);
    }
}
