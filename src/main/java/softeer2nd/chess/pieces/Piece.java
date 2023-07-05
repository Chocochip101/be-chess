package softeer2nd.chess.pieces;

public class Piece {
    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";
    public final static char WHITE_REPRESENTATION = 'p';
    public final static char BLACK_REPRESENTATION = 'P';
    private final String color;
    private final char representation;
    private Point point;

    public Piece() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Piece(final String color, final Character representation, int xCord, int yCord) {
        this.color = color;
        this.representation = representation;
        this.point = new Point(xCord, yCord);
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }

    public Point getPoint() {
        return this.point;
    }

}