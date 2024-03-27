package exercise.refactoring_pattern.pieces;

import exercise.refactoring_pattern.Color;
import exercise.refactoring_pattern.Position;


/**
 * EXERCISE:
 * Refactor this class by using a Design Pattern
 * together with ChessBoard.placeOtherPieces method
 *
 */
public abstract class Piece
{
    private Color _color;

    public Piece(Color color)
    {
        _color = color;
    }

    public Color getColor()
    {
        return _color;
    }

    public abstract boolean isValidMove(Position from, Position to);
}
