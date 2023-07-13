package softeer2nd.chess.game;

import softeer2nd.chess.board.Board;
import softeer2nd.chess.exception.IllegalMovePositionException;
import softeer2nd.chess.exception.OutOfBoardException;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import static softeer2nd.chess.pieces.PieceFactory.createBlank;

public class ChessGame {
    private final static int BOARD_SIZE = 7;
    private final Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public void move(String source, String target) {
        Point sourcePoint = new Point(source);
        Point targetPoint = new Point(target);
        Piece piece = findPiece(source);

        verifyMovementPosition(sourcePoint, targetPoint);
        possibleToMove(sourcePoint, targetPoint);

        board.getRankList().get(targetPoint.getY()).move(targetPoint.getX(), piece);
        piece.setPoint(targetPoint);
        board.getRankList().get(sourcePoint.getY()).move(sourcePoint.getX(), createBlank(sourcePoint));
    }

    public void verifyMovementPosition(Point sourcePoint, Point targetPoint) {
        if (targetPoint.equals(sourcePoint)) {
            throw new OutOfBoardException();
        }
        if (targetPoint.getY() < 0 || targetPoint.getY() > BOARD_SIZE || targetPoint.getX() < 0 || targetPoint.getX() > BOARD_SIZE) {
            throw new OutOfBoardException();
        }
        if (board.findPiece(sourcePoint).getColor().equals(board.findPiece(targetPoint).getColor())) {
            throw new IllegalMovePositionException();
        }
    }

    public boolean possibleToMove(Point sourcePoint, Point targetPoint) {
        Piece piece = board.findPiece(sourcePoint);

        Direction direction = targetPoint.getDirection(sourcePoint);
        System.out.println(direction);
        if (direction.isNone()) {
            throw new IllegalMovePositionException();
        }
        if (piece.getType() == Piece.Type.KNIGHT && isKnightMoving(direction)) {
            return true;
        }

        int count = Math.abs(targetPoint.getX() - sourcePoint.getX());
        if (targetPoint.getX() == sourcePoint.getX()) {
            count = Math.abs(targetPoint.getY() - sourcePoint.getY());
        }

        if (piece.isMovablePositionByDirection(direction, count)
                && nextStep(sourcePoint.getX(), sourcePoint.getY(), direction, count)) {
            return true;
        }
        throw new IllegalMovePositionException();
    }

    private boolean isKnightMoving(Direction direction) {
        return Direction.knightDirection().contains(direction);
    }

    private boolean nextStep(int x, int y, Direction direction, int count) {
        if (count == 0) return true;
        boolean result = true;

        if (board.getRankList().get(y).findPiece(x).isBlank()) {
            int nextRow = x + direction.getXDegree();
            int nextCol = y + direction.getYDegree();
            result &= nextStep(nextRow, nextCol, direction, count - 1);
        }
        return result;
    }

    public Piece findPiece(String strPoint) {
        Point p = new Point(strPoint);
        return board.getRankList().get(p.getY()).findPiece(p.getX());
    }
}
