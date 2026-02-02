package extra_exercises.refactoring;

public class Direction {
    private final int rowOffset;
    private final int columnOffset;

    public Direction(int rowOffset, int columnOffset) {
        this.rowOffset = rowOffset;
        this.columnOffset = columnOffset;
    }

    public int getRowOffset() {
        return rowOffset;
    }

    public int getColumnOffset() {
        return columnOffset;
    }
}
