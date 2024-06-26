package refactoring.parallelinheritence;

public class CivilEngineerNew implements Engineer {
    private String type;
    private int salary;
    private MileStone mileStone;

    public void setType(String type) {
        this.type = type;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setMileStone(MileStone mileStone) {
        this.mileStone = mileStone;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public MileStone getMileStone() {
        return mileStone;
    }

    @Override
    public String toString() {
        return "ComputerEngineer [type="
                + type
                + ", salary="
                + salary
                + ", mileStone="
                + mileStone
                + "]";
    }
}
