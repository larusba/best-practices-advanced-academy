package exercise.refactoring.pieces;

import exercise.refactoring.Color;

public class Queen extends Piece
{
    public Queen(Color color)
    {
        super(color, 'q');
    }

    @Override
    public String toString()
    {
        return "q";
    }
}
