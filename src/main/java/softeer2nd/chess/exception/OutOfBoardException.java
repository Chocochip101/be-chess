package softeer2nd.chess.exception;

public class OutOfBoardException extends ChessException {
    private static final String MESSAGE = "체스판 범위를 벗어난 위치입니다";

    public OutOfBoardException() {
        super(MESSAGE);
    }
}