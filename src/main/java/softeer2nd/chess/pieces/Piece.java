package softeer2nd.chess.pieces;

import java.util.Objects;

public class Piece {
    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";
    public final static char PAWN_REPRESENTATION = 'p';
    public final static char ROOK_REPRESENTATION = 'r';
    public final static char KNIGHT_REPRESENTATION = 'n';
    public final static char BISHOP_REPRESENTATION = 'b';
    public final static char QUEEN_REPRESENTATION = 'q';
    public final static char KING_REPRESENTATION = 'k';
    public final static char NO_REPRESENTATION = '.';

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN(PAWN_REPRESENTATION), ROOK(ROOK_REPRESENTATION), KNIGHT(KNIGHT_REPRESENTATION), BISHOP(BISHOP_REPRESENTATION),
        QUEEN(QUEEN_REPRESENTATION), KING(KING_REPRESENTATION), NO_PIECE(NO_REPRESENTATION);
        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }
    }

    private final Color color;
    private final Type type;
    private final Point point;

    private Piece(Color color, Type type, Point point) {
        this.color = color;
        this.type = type;
        this.point = point;
    }

    private static Piece creatWhite(Type type, Point point) {
        return new Piece(Color.WHITE, type, point);
    }

    private static Piece creatBlack(Type type, Point point) {
        return new Piece(Color.BLACK, type, point);
    }

    public static Piece createWhitePawn(Point point) {
        return creatWhite(Type.PAWN, point);
    }

    public static Piece createBlackPawn(Point point) {
        return creatBlack(Type.PAWN, point);
    }

    public static Piece createWhiteRook(Point point) {
        return creatWhite(Type.ROOK, point);
    }

    public static Piece createBlackRook(Point point) {
        return creatBlack(Type.ROOK, point);
    }

    public static Piece createWhiteKnight(Point point) {
        return creatWhite(Type.KNIGHT, point);
    }

    public static Piece createBlackKnight(Point point) {
        return creatBlack(Type.KNIGHT, point);
    }

    public static Piece createWhiteBishop(Point point) {
        return creatWhite(Type.BISHOP, point);
    }

    public static Piece createBlackBishop(Point point) {
        return creatBlack(Type.BISHOP, point);
    }

    public static Piece createWhiteQueen(Point point) {
        return creatWhite(Type.QUEEN, point);
    }

    public static Piece createBlackQueen(Point point) {
        return creatBlack(Type.QUEEN, point);
    }

    public static Piece createWhiteKing(Point point) {
        return creatWhite(Type.KING, point);
    }

    public static Piece createBlackKing(Point point) {
        return creatBlack(Type.KING, point);
    }

    public boolean isWhite() {
        return checkColor(Color.WHITE);
    }

    public boolean isBlack() {
        return checkColor(Color.BLACK);
    }

    private boolean checkColor(Color color) {
        return this.color.equals(color);
    }

    public Color getColor() {
        return color;
    }

    public Point getPoint() {
        return point;
    }

    public Type getType() {
        return type;
    }

    public char getRepresentation() {
        return checkColor(Color.WHITE) ? type.getWhiteRepresentation() : type.getBlackRepresentation();
    }
}