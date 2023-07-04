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
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertThat(verifyPawn(pawn, Pawn.WHITE_COLOR)).isEqualTo(true);
    }

    private boolean verifyPawn(Pawn pawn, final String color) {
        return pawn.getColor().equals(color);
    }
}