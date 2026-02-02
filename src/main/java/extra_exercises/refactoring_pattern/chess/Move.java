package extra_exercises.refactoring_pattern.chess;

import extra_exercises.refactoring_pattern.Position;

public class Move {
    private Position _from, _to;

    public Move(Position from, Position to) {
        _from = from;
        _to = to;
    }

    public Position getFrom() {
        return _from;
    }

    public Position getTo() {
        return _to;
    }
}
