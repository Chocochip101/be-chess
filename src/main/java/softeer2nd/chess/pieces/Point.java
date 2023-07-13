package softeer2nd.chess.pieces;

import softeer2nd.chess.game.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Point {
    public final static int ROW_COUNT = 8;
    private final int x;
    private final int y;


    public Point(String strPoint) {
        x = strPoint.charAt(0) - 'a' + 1;
        y = Character.getNumericValue(strPoint.charAt(1));
    }

    public Point(final int x, final int y) {
        this.x = x + 1;
        this.y = y + 1;
    }

    public int getX() {
        return x - 1;
    }

    public int getY() {
        return y - 1;
    }

    public Direction getDirection(Point targetPoint) {
        int dX = getX() - targetPoint.getX();
        int dY = getY() - targetPoint.getY();
        if (dX == 0) {
            return Direction.getDirection(0, dY);
        }
        if (dY == 0) {
            return Direction.getDirection(dX, 0);
        }
        if (Math.abs(dX) == Math.abs(dY)) {
            return Direction.getDirection(dX / Math.abs(dX), dY / Math.abs(dY));
        }
        return Direction.getDirection(dX, dY);
    }

    public List<Point> SameCol() {
        List<Point> positions = new ArrayList<>();
        IntStream.rangeClosed(0, ROW_COUNT)
                .forEach(idx -> {
                    if (idx != getY()) {
                        positions.add(new Point(getX(), idx));
                    }
                });

        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
