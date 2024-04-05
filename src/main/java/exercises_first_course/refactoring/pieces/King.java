package exercises_first_course.refactoring.pieces;

import exercises_first_course.refactoring.Color;

public class King extends Piece {
    public King(Color color) {
        super(color, 'K');
    }

    @Override
    public String toString() {
        return "K";
    }
}
