package softeer2nd.chess.game;

import softeer2nd.chess.board.Board;
import softeer2nd.chess.exception.BlankException;
import softeer2nd.chess.exception.IllegalMovePositionException;
import softeer2nd.chess.exception.IllegalTurnException;
import softeer2nd.chess.exception.OutOfBoardException;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import static softeer2nd.chess.pieces.PieceFactory.createBlank;

public class ChessGame {
    private final static int BOARD_SIZE = 7;
    private final Board board;
    private Piece.Color turnColor;

    public ChessGame(Board board) {
        this.board = board;
        this.turnColor = Piece.Color.WHITE;
    }

    public void move(String source, String target) {
        Point sourcePoint = new Point(source);
        Point targetPoint = new Point(target);
        Piece piece = board.findPiece(sourcePoint.getX(), sourcePoint.getY());

        checkIsBlank(piece);
        checkTurnColor(piece);
        verifyMovementPosition(sourcePoint, targetPoint);
        possibleToMove(sourcePoint, targetPoint);

        board.getRankList().get(targetPoint.getY()).move(targetPoint.getX(), piece);
        piece.setPoint(targetPoint);
        board.getRankList().get(sourcePoint.getY()).move(sourcePoint.getX(), createBlank(sourcePoint));
        flipTurnColor();
    }

    public Piece.Color getTurn() {
        return this.turnColor;
    }

    private void checkTurnColor(Piece piece) {
        if (!piece.isSameColor(turnColor)) {
            throw new IllegalTurnException();
        }
    }

    private void flipTurnColor() {
        if (this.turnColor.equals(Piece.Color.WHITE)) {
            this.turnColor = Piece.Color.BLACK;
        } else {
            this.turnColor = Piece.Color.WHITE;
        }
    }

    private void checkIsBlank(Piece piece) {
        if (piece.isBlank()) {
            throw new BlankException();
        }
    }

    private void verifyMovementPosition(Point sourcePoint, Point targetPoint) {
        checkSourceAndTargetIsSame(sourcePoint, targetPoint);
        verifyBoardBound(sourcePoint);
        verifyBoardBound(targetPoint);
        checkSourceAndTargetColor(sourcePoint, targetPoint);
    }

    private void checkSourceAndTargetColor(Point sourcePoint, Point targetPoint) {
        if (board.findPiece(sourcePoint).getColor().equals(board.findPiece(targetPoint).getColor())) {
            throw new IllegalMovePositionException();
        }
    }

    private static void verifyBoardBound(Point targetPoint) {
        if (targetPoint.getY() < 0 || targetPoint.getY() > BOARD_SIZE || targetPoint.getX() < 0 || targetPoint.getX() > BOARD_SIZE) {
            throw new OutOfBoardException();
        }
    }

    private static void checkSourceAndTargetIsSame(Point sourcePoint, Point targetPoint) {
        if (targetPoint.equals(sourcePoint)) {
            throw new OutOfBoardException();
        }
    }

    private void possibleToMove(Point sourcePoint, Point targetPoint) {
        Piece piece = board.findPiece(sourcePoint);
        Direction direction = targetPoint.getDirection(sourcePoint);

        checkDirectionNotFound(direction);
        if (piece.getType() == Piece.Type.KNIGHT && isKnightMoving(direction)) {
            return;
        }

        int count = getCount(sourcePoint, targetPoint);

        checkPawn(targetPoint, piece, direction);
        if (piece.isMovablePositionByDirection(direction, count)
                && isNextStepPossible(sourcePoint.getX(), sourcePoint.getY(), direction, count)) {
            return;
        }
        throw new IllegalMovePositionException();
    }

    private void checkPawn(Point targetPoint, Piece piece, Direction direction) {
        if (piece.getType().equals(Piece.Type.PAWN)) {
            checkPawnDiagonal(targetPoint, piece, direction);
        }
    }

    private void checkPawnDiagonal(Point targetPoint, Piece piece, Direction direction) {
        if (!verifyPawnDiagonal(piece, direction, targetPoint)) {
            throw new IllegalMovePositionException();
        }
    }

    private boolean verifyPawnDiagonal(Piece piece, Direction direction, Point targetPoint) {
        if (direction == Direction.SOUTH || direction == Direction.NORTH) {
            return true;
        }
        if (isBlackDiagonalDirection(direction) && piece.isBlack() && !board.findPiece(targetPoint).isBlank()) {
            return true;
        }
        if (isWhiteDiagonalDirection(direction) && piece.isWhite() && !board.findPiece(targetPoint).isBlank()) {
            return true;
        }
        return false;
    }

    private static boolean isBlackDiagonalDirection(Direction direction) {
        return direction == Direction.SOUTHEAST || direction == Direction.SOUTHWEST;
    }

    private static boolean isWhiteDiagonalDirection(Direction direction) {
        return direction == Direction.NORTHEAST || direction == Direction.NORTHWEST;
    }

    private static void checkDirectionNotFound(Direction direction) {
        if (direction.isNone()) {
            throw new IllegalMovePositionException();
        }
    }

    private static int getCount(Point sourcePoint, Point targetPoint) {
        int count = Math.abs(targetPoint.getX() - sourcePoint.getX());
        if (targetPoint.getX() == sourcePoint.getX()) {
            count = Math.abs(targetPoint.getY() - sourcePoint.getY());
        }
        return count;
    }

    private boolean isKnightMoving(Direction direction) {
        return Direction.knightDirection().contains(direction);
    }

    private boolean isNextStepPossible(int x, int y, Direction direction, int count) {
        if (count <= 0) {
            return true;
        }
        boolean result = true;

        int nextX = x + direction.getXDegree();
        int nextY = y + direction.getYDegree();
        if (count != 1 && !board.findPiece(nextX, nextY).isBlank()) {
            return false;
        }
        isNextStepPossible(nextX, nextY, direction, count - 1);
        return result;
    }
}
