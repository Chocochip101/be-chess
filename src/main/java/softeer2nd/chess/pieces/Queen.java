package softeer2nd.chess.pieces;

import softeer2nd.chess.game.Direction;

public class Queen extends Piece {
    protected Queen(Color color, Point point) {
        super(color, Type.QUEEN, point);
    }

    @Override
    public boolean isMovablePositionByDirection(Direction direction, int count) {
        return Direction.everyDirection().contains(direction);
    }
}
