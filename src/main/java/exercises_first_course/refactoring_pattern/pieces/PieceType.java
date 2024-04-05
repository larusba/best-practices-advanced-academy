package exercises_first_course.refactoring_pattern.pieces;

import static exercises_first_course.refactoring_pattern.chess.ChessBoard.BOARD_SIZE;

import exercises_first_course.refactoring_pattern.Color;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public enum PieceType {
    BISHOP(Bishop::new, column -> (column == 2 || column == BOARD_SIZE - 3)),
    ROOK(Rook::new, column -> (column == 0 || column == BOARD_SIZE - 1)),
    KNIGHT(Knight::new, column -> (column == 1 || column == BOARD_SIZE - 2)),
    KING(King::new, column -> (column == 3)),
    QUEEN(Queen::new, column -> (column == 4));

    final Function<Color, Piece> funCreateInstance;
    final Predicate<Integer> predicatePlacePiece;

    PieceType(Function<Color, Piece> funCreateInstance, Predicate<Integer> predicatePlacePiece) {
        this.funCreateInstance = funCreateInstance;
        this.predicatePlacePiece = predicatePlacePiece;
    }

    public Function<Color, Piece> getFunCreateInstance() {
        return funCreateInstance;
    }

    public Predicate<Integer> getPredicatePlacePiece() {
        return predicatePlacePiece;
    }

    public static Piece placePieceFromColumnAndColor(int column, Color color) {
        return Arrays.stream(PieceType.values())
                .filter(i -> i.getPredicatePlacePiece().test(column))
                .findFirst()
                .get()
                .getFunCreateInstance()
                .apply(color);
    }
}
