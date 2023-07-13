package softeer2nd.chess.exception;

public class IllegalCreatePieceException extends ChessException {
    private static final String MESSAGE = "기물 생성 오류입니다.";

    public IllegalCreatePieceException() {
        super(MESSAGE);
    }
}