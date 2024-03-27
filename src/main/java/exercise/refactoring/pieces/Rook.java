package exercise.refactoring.pieces;

import exercise.refactoring.Color;

public abstract class Rook extends Piece
{
    public Rook(Color color)
    {
        super(color, 'r');
    }

    @Override
    public String toString()
    {
        return "r";
    }
}
