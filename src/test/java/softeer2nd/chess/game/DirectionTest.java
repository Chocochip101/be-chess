package softeer2nd.chess.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.game.Direction.getDirection;

class DirectionTest {
    @Test
    @DisplayName("Direction을 검증한다.")
    public void validPointToDirection() {
        // given
        int x = 2;
        int y = 1;

        // when
        Direction dir = getDirection(x, y);

        // then
        assertEquals(dir, Direction.EEN);
    }

}