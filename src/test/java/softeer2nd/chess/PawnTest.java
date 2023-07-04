package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    @Test
    @DisplayName("색에 맞는 폰이 생성되어야 한다")
    public void create() {
        Pawn pawn = new Pawn(Pawn.WHITE_COLOR);
        assertThat(pawn.verifyPawn(Pawn.WHITE_COLOR)).isEqualTo(true);
        Pawn secondPawn = new Pawn(Pawn.BLACK_COLOR);
        assertThat(secondPawn.verifyPawn(Pawn.BLACK_COLOR)).isEqualTo(true);
    }

    @Test
    public void create_기본생성자() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE_COLOR, pawn.getColor());
    }
}