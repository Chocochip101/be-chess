package softeer2nd.chess.pieces;

import softeer2nd.chess.board.Board;
import softeer2nd.chess.exception.IllegalMovePositionException;
import softeer2nd.chess.game.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static softeer2nd.chess.pieces.PieceFactory.createPiece;

public abstract class Piece implements Comparable<Piece> {
    public final static char PAWN_REPRESENTATION = 'p';
    public final static char ROOK_REPRESENTATION = 'r';
    public final static char KNIGHT_REPRESENTATION = 'n';
    public final static char BISHOP_REPRESENTATION = 'b';
    public final static char QUEEN_REPRESENTATION = 'q';
    public final static char KING_REPRESENTATION = 'k';
    public final static char NO_REPRESENTATION = '.';
    public final static double PAWN_SCORE = 1.0;
    public final static double ROOK_SCORE = 5.0;
    public final static double KNIGHT_SCORE = 2.5;
    public final static double BISHOP_SCORE = 3.0;
    public final static double QUEEN_SCORE = 9.0;
    public final static double KING_SCORE = 0.0;
    public final static double NO_PIECE_SCORE = 0.0;
    public final static double SUBTRACT_SCORE_SAME_LINE = 0.5;
    public final static int BOARD_MAX = 7;
    public final static int BOARD_MIN = 1;
    public final static int KING_DISTANCE = 1;

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN(PAWN_REPRESENTATION, PAWN_SCORE), ROOK(ROOK_REPRESENTATION, ROOK_SCORE), KNIGHT(KNIGHT_REPRESENTATION, KNIGHT_SCORE),
        BISHOP(BISHOP_REPRESENTATION, BISHOP_SCORE), QUEEN(QUEEN_REPRESENTATION, QUEEN_SCORE), KING(KING_REPRESENTATION, KING_SCORE),
        NO_PIECE(NO_REPRESENTATION, NO_PIECE_SCORE);
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
    private Point point;

    protected Piece(Color color, Type type, Point point) {
        this.color = color;
        this.type = type;
        this.point = point;
    }

    public boolean isWhite() {
        return checkColor(Color.WHITE);
    }

    public boolean isBlack() {
        return checkColor(Color.BLACK);
    }

    public boolean isBlank() {
        return type.equals(Type.NO_PIECE);
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

    public void setPoint(Point point) {
        this.point = point;
    }

    public char getRepresentation() {
        return checkColor(Color.WHITE) ? type.getWhiteRepresentation() : type.getBlackRepresentation();
    }

    public void addPiecesByColor(Color color, List<Piece> pieceList) {
        if (checkColor(color)) {
            pieceList.add(this);
        }
    }


    public abstract boolean isMovablePositionByDirection(Direction direction, int count);

    public boolean checkColorType(Color color, Type type) {
        return (this.color == color) && (this.type == type);
    }

    public double getScores(List<Piece> pieces) {
        if (this.type != Type.PAWN) {
            return type.getScore();
        }
        for (Point point : this.getPoint().SameCol()) {
            if (pieces.contains(createPiece(this.color, this.type, point))) {
                return type.getScore() - SUBTRACT_SCORE_SAME_LINE;
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