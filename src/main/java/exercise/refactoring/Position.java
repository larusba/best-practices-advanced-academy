package exercise.refactoring;

public class Position
{
    private final int row;
    private final int column;

    public Position(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }

    @Override
    public String toString()
    {
        return "(ROW: " + row + ", COLUMN: " + column + ")";
    }

    @Override
    public boolean equals(Object obj)
    {
        
        if (obj == null || !(obj instanceof Position))
            return false;
        Position otherPosition = (Position) obj;
        return this == obj || (row == otherPosition.getRow() && column == otherPosition.getColumn());
    }

    public Position translatedPosition(Direction direction) {
        return new Position(getRow() + direction.getRowOffset(), getColumn() + direction.getColumnOffset());
    }
}
