package softeer2nd.chess.exception;

public class BlankException extends ChessException {
    private static final String MESSAGE = "빈 칸은 움직일 수 없습니다.";

    public BlankException() {
        super(MESSAGE);
    }
}