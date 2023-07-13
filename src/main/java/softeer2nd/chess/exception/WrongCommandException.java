package softeer2nd.chess.exception;

public class WrongCommandException extends ChessException {
    private static final String MESSAGE = "잘못된 명령어를 입력하셨습니다.";

    public WrongCommandException() {
        super(MESSAGE);
    }
}
