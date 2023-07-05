package softeer2nd.chess.pieces;

public class Piece {
    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";
    public final static char WHITE_PAWN_REPRESENTATION = 'p';
    public final static char BLACK_PAWN_REPRESENTATION = 'P';
    public final static char WHITE_ROOK_REPRESENTATION = 'r';
    public final static char BLACK_ROOK_REPRESENTATION = 'R';
    public final static char WHITE_KNIGHT_REPRESENTATION = 'n';
    public final static char BLACK_KNIGHT_REPRESENTATION = 'N';
    public final static char WHITE_BISHOP_REPRESENTATION = 'b';
    public final static char BLACK_BISHOP_REPRESENTATION = 'B';
    public final static char WHITE_QUEEN_REPRESENTATION = 'q';
    public final static char BLACK_QUEEN_REPRESENTATION = 'Q';
    public final static char WHITE_KING_REPRESENTATION = 'k';
    public final static char BLACK_KING_REPRESENTATION = 'K';

    private final String color;
    private final char representation;
    private final Point point;

    private Piece(String color, char representation, Point point) {
        this.color = color;
        this.representation = representation;
        this.point = point;
    }

    private static Piece creatWhite(char representation, Point point) {
        return new Piece(WHITE_COLOR, representation, point);
    }

    private static Piece creatBlack(char representation, Point point) {
        return new Piece(BLACK_COLOR, representation, point);
    }

    public static Piece createWhitePawn(Point point) {
        return creatWhite(WHITE_PAWN_REPRESENTATION, point);
    }

    public static Piece createBlackPawn(Point point) {
        return creatBlack(BLACK_PAWN_REPRESENTATION, point);
    }

    public static Piece createWhiteRook(Point point) {
        return creatWhite(WHITE_ROOK_REPRESENTATION, point);
    }

    public static Piece createBlackRook(Point point) {
        return creatBlack(BLACK_ROOK_REPRESENTATION, point);
    }

    public static Piece createWhiteKnight(Point point) {
        return creatWhite(WHITE_KNIGHT_REPRESENTATION, point);
    }

    public static Piece createBlackKnight(Point point) {
        return creatBlack(BLACK_KNIGHT_REPRESENTATION, point);
    }

    public static Piece createWhiteBishop(Point point) {
        return creatWhite(WHITE_BISHOP_REPRESENTATION, point);
    }

    public static Piece createBlackBishop(Point point) {
        return creatBlack(BLACK_BISHOP_REPRESENTATION, point);
    }

    public static Piece createWhiteQueen(Point point) {
        return creatWhite(WHITE_QUEEN_REPRESENTATION, point);
    }

    public static Piece createBlackQueen(Point point) {
        return creatBlack(BLACK_QUEEN_REPRESENTATION, point);
    }

    public static Piece createWhiteKing(Point point) {
        return creatWhite(WHITE_KING_REPRESENTATION, point);
    }

    public static Piece createBlackKing(Point point) {
        return creatBlack(BLACK_KING_REPRESENTATION, point);
    }

    public boolean isWhite() {
        return checkColor(WHITE_COLOR);
    }

    public boolean isBlack() {
        return checkColor(BLACK_COLOR);
    }

    private boolean checkColor(String color) {
        return this.color.equals(color);
    }

    public String getColor() {
        return color;
    }

    public Point getPoint() {
        return point;
    }

    public char getRepresentation() {
        return representation;
    }
}