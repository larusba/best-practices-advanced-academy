package extra_exercises.refactoring.pieces;

import extra_exercises.refactoring.Color;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, 'q');
    }

    @Override
    public String toString() {
        return "q";
    }
}
