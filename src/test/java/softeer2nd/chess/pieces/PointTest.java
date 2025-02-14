package softeer2nd.chess.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.game.Direction;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    private final int x = 1;
    private final int y = 1;
    Point point = new Point(x, y);

    @Test
    @DisplayName("x값을 반환한다.")
    public void returnXTest() {
        assertEquals(point.getX(), x);
    }

    @Test
    @DisplayName("y값을 반환한다.")
    public void returnYTest() {
        assertEquals(point.getY(), y);
    }

    @Test
    @DisplayName("point를 방향으로 반환한다.")
    public void pointDirectionTest() {
        // given
        String source = "b1";
        String target = "c3";

        // when
        Point sourcePoint = new Point(source);
        Point targetPoint = new Point(target);
        Direction dir = targetPoint.getDirection(sourcePoint);

        // then
        assertEquals(dir, Direction.NNE);
    }
}