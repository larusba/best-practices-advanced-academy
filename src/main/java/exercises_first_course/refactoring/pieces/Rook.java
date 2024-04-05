package exercises_first_course.refactoring.pieces;

import exercises_first_course.refactoring.Color;

public abstract class Rook extends Piece {
    public Rook(Color color) {
        super(color, 'r');
    }

    @Override
    public String toString() {
        return "r";
    }
}
