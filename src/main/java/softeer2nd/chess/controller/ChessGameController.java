package softeer2nd.chess.controller;

import softeer2nd.chess.board.Board;
import softeer2nd.chess.view.InputView;
import softeer2nd.chess.view.OutputView;

import java.util.Scanner;

public class ChessGameController {
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void main() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        outputView.printStartProgram();

        while (isRunning) {
            isRunning = checkCommand(inputView.inputUserCommand(scanner));
        }

        outputView.printFinishProgram();
        scanner.close();
    }

    private boolean checkCommand(String input) {
        if (input.equals(END_COMMAND)) {
            return false;
        } else if (input.equals(START_COMMAND)) {
            Board board = new Board();
            board.initialize();
            System.out.println(board.showBoard());
        } else {
            outputView.printWrongCommand();
        }
        return true;
    }
}
