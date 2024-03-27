package exercise.refactoring_pattern.pieces;

import exercise.refactoring_pattern.Color;
import exercise.refactoring_pattern.Position;
import exercise.refactoring_pattern.chess.MoveUtil;

import java.util.function.Predicate;

import static exercise.refactoring_pattern.chess.ChessBoard.BOARD_SIZE;

//Fixed Collapsing Hierarchy (another instance of lazy-class)
public class Bishop extends Piece
{

    public Bishop(Color color)
    {
        super(color);
    }

    @Override
    public boolean isValidMove(Position from, Position to)
    {
        return MoveUtil.isDiagonalMove(from, to);
    }

    @Override
    public String toString()
    {
        return "b";
    }

    public Predicate<Integer> getValidColumnPredicate() {
        return column -> (column == 2 || column == BOARD_SIZE - 3);
    }
}
