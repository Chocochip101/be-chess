package softeer2nd.chess.view;

import softeer2nd.chess.pieces.Piece;

public class OutputView {
    private static final String WELCOME_COMMAND = "체스 프로그램을 시작합니다.";
    private static final String FINISH_COMMAND = "프로그램을 종료합니다.";

    public void printStartProgram() {
        System.out.println(WELCOME_COMMAND);
    }

    public void print(String result) {
        System.out.println(result);
    }

    public void turnCommand(Piece.Color turn) {
        System.out.println(turn.toString() + " 턴입니다.");
    }

    public void terminateProgram() {
        System.out.println(FINISH_COMMAND);
    }

    public void printWhiteScore(double score) {
        System.out.println("White Score: " + score);
    }

    public void printBlackScore(double score) {
        System.out.println("Black Score: " + score);
    }
}
