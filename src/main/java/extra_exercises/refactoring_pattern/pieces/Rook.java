package extra_exercises.refactoring_pattern.pieces;

import extra_exercises.refactoring_pattern.Color;
import extra_exercises.refactoring_pattern.Position;
import extra_exercises.refactoring_pattern.chess.MoveUtil;

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
