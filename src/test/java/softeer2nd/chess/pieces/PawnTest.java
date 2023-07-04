package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    Pawn white;

    @BeforeEach
    void setup() {
        white = new Pawn();
    }

    @Test
    @DisplayName("색에 맞는 폰이 생성되어야 한다")
    public void create() {
        assertThat(white.verifyPawn(Pawn.WHITE_COLOR)).isEqualTo(true);
        Pawn secondPawn = new Pawn(Pawn.BLACK_COLOR);
        assertThat(secondPawn.verifyPawn(Pawn.BLACK_COLOR)).isEqualTo(true);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }
}