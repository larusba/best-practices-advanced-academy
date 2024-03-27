package exercise.refactoring.pieces;

import exercise.refactoring.Color;

public abstract class Bishop extends Piece
{

    public Bishop(Color color)
    {
        super(color, 'b');
    }

    @Override
    public String toString()
    {
        return "b";
    }
}
