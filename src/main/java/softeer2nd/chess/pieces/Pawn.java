package softeer2nd.chess.pieces;

public class Pawn {
    public final static String WHITE_COLOR = "white";

    public final static String BLACK_COLOR = "black";
    private String color;

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(final String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}