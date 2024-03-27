package exercise.refactoring.pieces;

import exercise.refactoring.Color;

public class King extends Piece
{
    public King(Color color)
    {
        super(color, 'K');
    }

    @Override
    public String toString()
    {
        return "K";
    }
}
