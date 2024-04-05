package exercises_first_course.refactoring.pieces;

import exercises_first_course.refactoring.Color;

public abstract class Knight extends Piece {
    public Knight(Color color) {
        super(color, 'k');
    }

    @Override
    public String toString() {
        return "k";
    }
}
