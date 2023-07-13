package softeer2nd.chess.pieces;

import softeer2nd.chess.game.Direction;

public class Rook extends Piece {
    protected Rook(Color color, Point point) {
        super(color, Type.ROOK, point);
    }

    @Override
    public boolean isMovablePositionByDirection(Direction direction, int count) {
        return Direction.linearDirection().contains(direction);
    }
}
