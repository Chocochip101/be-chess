package softeer2nd;

public class Pawn {
    private String color;

    Pawn(final String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    public boolean verifyPawn(final String color){
        return this.color.equals(color);
    }
}
