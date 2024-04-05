package exercises_first_course.refactoring_pattern.pieces;

import static exercises_first_course.refactoring_pattern.chess.ChessBoard.BOARD_SIZE;

import exercises_first_course.refactoring_pattern.Color;
import exercises_first_course.refactoring_pattern.Position;
import exercises_first_course.refactoring_pattern.chess.MoveUtil;
import java.util.function.Predicate;

// Fixed Collapsing Hierarchy (another instance of lazy-class)
public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Position from, Position to) {
        return MoveUtil.isDiagonalMove(from, to);
    }

    @Override
    public String toString() {
        return "b";
    }

    public Predicate<Integer> getValidColumnPredicate() {
        return column -> (column == 2 || column == BOARD_SIZE - 3);
    }
}
