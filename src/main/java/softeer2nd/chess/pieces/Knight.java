package softeer2nd.chess.pieces;

import softeer2nd.chess.game.Direction;


public class Knight extends Piece {
    protected Knight(Color color, Point point) {
        super(color, Type.KNIGHT, point);
    }

    @Override
    public boolean isMovablePositionByDirection(Direction direction, int count) {
        return false;
    }
}
