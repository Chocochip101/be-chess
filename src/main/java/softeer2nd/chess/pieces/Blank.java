package softeer2nd.chess.pieces;

import softeer2nd.chess.game.Direction;


public class Blank extends Piece {
    protected Blank(Point point) {
        super(Color.NOCOLOR, Type.NO_PIECE, point);
    }

    @Override
    public boolean isMovablePositionByDirection(Direction direction, int count) {
        return false;
    }
}
