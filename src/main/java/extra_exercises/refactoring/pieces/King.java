package extra_exercises.refactoring.pieces;

import extra_exercises.refactoring.Color;

public class King extends Piece {
    public King(Color color) {
        super(color, 'K');
    }

    @Override
    public String toString() {
        return "K";
    }
}
