package extra_exercises.refactoring.chess;

import extra_exercises.refactoring.Color;
import extra_exercises.refactoring.Direction;
import extra_exercises.refactoring.Position;
import extra_exercises.refactoring.pieces.King;
import extra_exercises.refactoring.pieces.Knight;
import extra_exercises.refactoring.pieces.Piece;

/**
 * Refactor code smells: - duplicated code - dead code - param. repetition - embedded code, to be
 * replaced for example with a var. with name `BOARD_SIZE` - - others...
 */
public class ChessBoard {
    public static final int BOARD_SIZE = 8;
    private final Cell[][] board;
    public boolean kingDead;
    public Player player1, player2;

    public ChessBoard() {
        board = new Cell[BOARD_SIZE][BOARD_SIZE];
        initBoard();
    }

    private void initBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                Color color = ((row + column) % 2 == 0) ? Color.WHITE : Color.BLACK;
                board[row][column] = new Cell(color);
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    private boolean isPositionOutOfBounds(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return row < 0 || row >= BOARD_SIZE || column < 0 || column >= BOARD_SIZE;
    }

    public boolean isEmpty(Position position) {
        return isPositionOutOfBounds(position) || getCell(position).isEmpty();
    }

    private Cell getCell(Position position) {
        return board[position.getRow()][position.getColumn()];
    }

    public Piece getPiece(Position position) {
        return isEmpty(position) ? null : getCell(position).getPiece();
    }

    public boolean isValidMove(int fromRow, int fromColumn, int toRow, int toColumn) {
        Position from = new Position(fromRow, fromColumn);
        Position to = new Position(toRow, toColumn);
        Piece piece = getPiece(from);

        return !from.equals(to)
                && !(isPositionOutOfBounds(from) || isPositionOutOfBounds(to))
                && !isEmpty(from)
                && (isEmpty(to) || piece.getColor() != getPiece(to).getColor())
                && piece.isValidMove(from, to)
                && hasNoPieceInPath(from, to);
    }

    private boolean hasNoPieceInPath(Position from, Position to) {
        if (getPiece(from) instanceof Knight) return true;
        if (!isStraightLineMove(from, to)) return false;
        Direction direction =
                new Direction(
                        cappedCompare(to.getRow(), from.getRow()),
                        cappedCompare(to.getColumn(), from.getColumn()));
        from = from.translatedPosition(direction);
        while (!from.equals(to)) {
            if (!isEmpty(from)) return false;
            from = to.translatedPosition(direction);
        }
        return true;
    }

    private boolean isStraightLineMove(Position from, Position to) {
        return Math.abs(from.getRow() - to.getRow()) == Math.abs(from.getColumn() - to.getColumn())
                || from.getRow() == to.getRow()
                || from.getColumn() == to.getColumn();
    }

    private int cappedCompare(int x, int y) {
        return Math.max(-1, Math.min(1, Integer.compare(x, y)));
    }

    public void movePiece(Position from, Position to) {
        updateIsKingDead(from);
        if (!getCell(to).isEmpty()) getCell(to).removePiece();
        getCell(to).setPiece(getPiece(from));
        getCell(from).removePiece();
    }

    private void updateIsKingDead(Position position) {
        if (getPiece(position) instanceof King) {
            kingDead = true;
        }
    }

    public boolean isKingDead() {
        return kingDead;
    }
}
