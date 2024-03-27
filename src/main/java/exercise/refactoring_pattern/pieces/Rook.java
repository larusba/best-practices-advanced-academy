package exercise.refactoring_pattern.pieces;


import exercise.refactoring_pattern.Color;
import exercise.refactoring_pattern.Position;
import exercise.refactoring_pattern.chess.MoveUtil;
//Fixed Collapsing Hierarchy (another instance of lazy-class)
public class Rook extends Piece
{
    public Rook(Color color)
    {
        super(color);
    }

    public boolean isValidMove(Position from, Position to)
    {
        return MoveUtil.isHorizontalOrVerticalMove(from, to);
    }

    @Override
    public String toString()
    {
        return "r";
    }
}
