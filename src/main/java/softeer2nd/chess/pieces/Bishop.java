package softeer2nd.chess.pieces;

import softeer2nd.chess.game.Direction;

public class Bishop extends Piece {
    protected Bishop(Color color, Point point) {
        super(color, Type.BISHOP, point);
    }

    @Override
    public boolean isMovablePositionByDirection(Direction direction, int count) {
        return Direction.diagonalDirection().contains(direction);
    }
}
