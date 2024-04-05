package exercises_first_course.refactoring_pattern.pieces;

import exercises_first_course.refactoring_pattern.Color;
import exercises_first_course.refactoring_pattern.Position;
import exercises_first_course.refactoring_pattern.chess.MoveUtil;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    public boolean isValidMove(Position from, Position to) {
        return MoveUtil.isStraightLineMove(from, to);
    }

    @Override
    public String toString() {
        return "q";
    }
}
