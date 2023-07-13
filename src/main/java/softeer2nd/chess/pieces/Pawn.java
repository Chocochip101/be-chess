package softeer2nd.chess.pieces;

import softeer2nd.chess.game.Direction;

import java.util.List;

import static softeer2nd.chess.game.Direction.*;

public class Pawn extends Piece {
    protected Pawn(Color color, Point point) {
        super(color, Type.PAWN, point);
    }

    @Override
    public boolean isMovablePositionByDirection(Direction direction, int count) {
        if (isBlack()) {
            return SOUTH == direction && count == 1;
        }
        return NORTH == direction && count == 1;
    }
}