package softeer2nd.chess.exception;

public abstract class ChessException extends RuntimeException {
    public ChessException(String message) {
        super(message);
    }
}
