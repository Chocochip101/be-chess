package softeer2nd.chess.pieces;

import softeer2nd.chess.game.Direction;


public class King extends Piece {
    protected King(Color color, Point point) {
        super(color, Type.KING, point);
    }

    @Override
    public boolean isMovablePositionByDirection(Direction direction, int count) {
        return Direction.everyDirection().contains(direction) && count == 1;
    }
}