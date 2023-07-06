package softeer2nd.chess.pieces;

import java.util.List;
import java.util.Objects;

public class Piece implements Comparable<Piece> {
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
        PAWN(PAWN_REPRESENTATION, 1.0), ROOK(ROOK_REPRESENTATION, 5.0), KNIGHT(KNIGHT_REPRESENTATION, 2.5),
        BISHOP(BISHOP_REPRESENTATION, 3.0), QUEEN(QUEEN_REPRESENTATION, 9.0), KING(KING_REPRESENTATION, 0.0),
        NO_PIECE(NO_REPRESENTATION, 0.0);
        private final char representation;
        private final double score;

        Type(char representation, double score) {
            this.representation = representation;
            this.score = score;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }

        public double getScore() {
            return this.score;
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

    public static Piece createBlank(Point point) {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE, point);
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

    public void addPiecesByColor(Color color, List<Piece> pieceList) {
        if (checkColor(color)) {
            pieceList.add(this);
        }
    }

    public boolean checkColorType(Color color, Type type) {
        return (this.color == color) && (this.type == type);
    }

    public double getScores(List<Piece> pieces) {
        if (this.type != Type.PAWN) {
            return type.getScore();
        }
        for (Point point : this.getPoint().SameCol()) {
            if (pieces.contains(new Piece(this.color, this.type, point))) {
                return type.getScore() - 0.5;
            }
        }
        return type.score;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type && Objects.equals(point, piece.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, point);
    }

    @Override
    public int compareTo(Piece piece) {
        return (int) (piece.type.getScore() * 2 - type.getScore() * 2);
    }
}