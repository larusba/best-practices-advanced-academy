package exercises_first_course.refactoring_pattern.pieces;

import exercises_first_course.refactoring_pattern.Color;
import exercises_first_course.refactoring_pattern.Position;
import exercises_first_course.refactoring_pattern.chess.MoveUtil;
// Fixed Collapsing Hierarchy (another instance of lazy-class)

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    public boolean isValidMove(Position from, Position to) {
        return MoveUtil.isHorizontalOrVerticalMove(from, to);
    }

    @Override
    public String toString() {
        return "r";
    }
}
