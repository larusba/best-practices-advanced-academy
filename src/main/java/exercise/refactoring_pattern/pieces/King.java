package exercise.refactoring_pattern.pieces;

import exercise.refactoring_pattern.Color;
import exercise.refactoring_pattern.Position;

public class King extends Piece
{
    public King(Color color)
    {
        super(color);
    }

    @Override
    public boolean isValidMove(Position from, Position to)
    {
        return (Math.abs(from.getRow() - to.getRow()) == 1) && (Math.abs(from.getColumn() - to.getColumn()) == 1);
    }

    @Override
    public String toString()
    {
        return "K";
    }
}
