package softeer2nd.chess.pieces;

import softeer2nd.chess.exception.IllegalCreatePieceException;

public class PieceFactory {
    private PieceFactory() {
    }

    public static Piece createPiece(Piece.Color color, Piece.Type type, Point point) {
        switch (type) {
            case KING:
                return new King(color, point);
            case QUEEN:
                return new Queen(color, point);
            case ROOK:
                return new Rook(color, point);
            case BISHOP:
                return new Bishop(color, point);
            case KNIGHT:
                return new Knight(color, point);
            case PAWN:
                return new Pawn(color, point);
            default:
                throw new IllegalCreatePieceException();
        }
    }

    public static Piece createBlank(Point point) {
        return new Blank(point);
    }
}