package exercises_first_course.refactoring.pieces;

import exercises_first_course.refactoring.Color;

public abstract class Bishop extends Piece {

    public Bishop(Color color) {
        super(color, 'b');
    }

    @Override
    public String toString() {
        return "b";
    }
}
