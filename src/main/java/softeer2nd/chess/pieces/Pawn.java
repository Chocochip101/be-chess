package softeer2nd.chess.pieces;

public class Pawn {
    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";
    public final static char WHITE_REPRESENTATION = 'p';
    public final static char BLACK_REPRESENTATION = 'P';
    private final String color;
    private final char representation;
    private int xCord;
    private int yCord;

    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(final String color, final Character representation, int xCord, int yCord) {
        this.color = color;
        this.representation = representation;
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public String getColor() {
        return this.color;
    }

    public char getRepresentation() {
        return this.representation;
    }

    public int getX(){
        return this.xCord;
    }

    public int getY(){
        return this.yCord;
    }
}