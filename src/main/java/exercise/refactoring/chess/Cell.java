package exercise.refactoring.chess;

import exercise.refactoring.Color;
import exercise.refactoring.pieces.Piece;

public class Cell
{
    private Piece piece;
    private Color color;

    public Cell(Color color)
    {
        this.color = color;
    }

    public void removePiece()
    {
        piece = null;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    public boolean isEmpty()
    {
        return piece == null;
    }

    @Override
    public String toString()
    {
        return piece == null
                ? ("." + color + ".")
                : (piece.getColor().toString() + color + piece.toString());
    }
}
