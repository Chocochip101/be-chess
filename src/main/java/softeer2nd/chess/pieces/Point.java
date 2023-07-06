package softeer2nd.chess.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Point {
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

    public List<Point> SameCol() {
        List<Point> positions = new ArrayList<>();
        for (int idx = 0; idx <= 8; idx++) {
            if (idx != getY()) {
                positions.add(new Point(getX(), idx));
            }
        }
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
