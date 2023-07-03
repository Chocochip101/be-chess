package softeer2nd;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        final String whiteColor = "white";
        final String blackColor = "black";

        Pawn pawn = new Pawn(whiteColor);
        assertThat(pawn.verifyPawn(whiteColor)).isEqualTo(true);

        Pawn secondPawn = new Pawn(blackColor);
        assertThat(secondPawn.verifyPawn(blackColor)).isEqualTo(true);
    }
}