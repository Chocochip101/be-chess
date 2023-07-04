package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    private Pawn white;

    @BeforeEach
    void setup() {
        white = new Pawn();
    }

    @Test
    public void create_기본생성자() throws Exception {
        assertEquals(Pawn.WHITE_COLOR, white.getColor());
        assertEquals(Pawn.WHITE_REPRESENTATION, white.getRepresentation());
    }

    @Test
    @DisplayName("색상에 맞는 폰이 생성되어야 한다")
    public void create() {
        verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }


    private void verifyPawn(final String color, final char representation) {
        Pawn pawn = new Pawn(color, representation, 0, 0);
        assertEquals(color, pawn.getColor());
        assertEquals(representation, pawn.getRepresentation());
    }
}