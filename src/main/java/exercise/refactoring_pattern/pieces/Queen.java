package exercise.refactoring_pattern.pieces;

import exercise.refactoring_pattern.Color;
import exercise.refactoring_pattern.Position;
import exercise.refactoring_pattern.chess.MoveUtil;

public class Queen extends Piece
{
    public Queen(Color color)
    {
        super(color);
    }

    public boolean isValidMove(Position from, Position to)
    {
        return MoveUtil.isStraightLineMove(from, to);
    }

    @Override
    public String toString()
    {
        return "q";
    }
}
