package softeer2nd;

public class Pawn {
    public final static Integer WHITE_COLOR = 1;
    public final static Integer BLACK_COLOR = 2;
    private Integer color;

    Pawn() {
        this.color = WHITE_COLOR;
    }

    Pawn(final Integer color) {
        this.color = color;
    }

    public Integer getColor() {
        return this.color;
    }

    public boolean verifyPawn(final Integer color) {
        return this.color.equals(color);
    }
}