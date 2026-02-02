package extra_exercises.refactoring.pieces;

import extra_exercises.refactoring.Color;

public abstract class Bishop extends Piece {

    public Bishop(Color color) {
        super(color, 'b');
    }

    @Override
    public String toString() {
        return "b";
    }
}
