package softeer2nd.chess.exception;

public class IllegalMovePositionException extends ChessException {
    private static final String MESSAGE = "해당 위치로 움직일 수 없습니다";

    public IllegalMovePositionException() {
        super(MESSAGE);
    }
}