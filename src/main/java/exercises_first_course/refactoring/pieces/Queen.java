package exercises_first_course.refactoring.pieces;

import exercises_first_course.refactoring.Color;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, 'q');
    }

    @Override
    public String toString() {
        return "q";
    }
}
