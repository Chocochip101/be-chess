package softeer2nd.chess.controller;

import softeer2nd.chess.board.Board;
import softeer2nd.chess.game.ChessGame;
import softeer2nd.chess.view.InputView;
import softeer2nd.chess.view.OutputView;

public class ChessGameController {
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";
    private static final String MOVE_COMMAND = "move";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void main() {
        outputView.printStartProgram();
        while (true) {
            String command = inputView.gameCommand();
            if (isNotExistCommand(command)) {
                outputView.printWrongCommand();
                throw new IllegalArgumentException("잘못된 커맨드 입력입니다.");
            }
            if (command.equals(END_COMMAND)) {
                break;
            }
            Board board = new Board();
            board.initialize();
            ChessGame chessGame = new ChessGame(board.getRankList());
            String moveCommand = inputView.moveCommand();
            if (isNotExistCommand(command)) {
                outputView.printWrongCommand();
                throw new IllegalArgumentException("잘못된 커맨드 입력입니다.");
            }
            move(chessGame, moveCommand);
            outputView.print(board.showBoard());
        }
    }

    private static boolean isNotExistCommand(final String command) {
        return !command.equals(START_COMMAND) && !command.equals(END_COMMAND) && !command.startsWith(MOVE_COMMAND);
    }

    private void move(ChessGame chessGame, String command) {
        String[] parsedResult = parseCommand(command);
        chessGame.move(parsedResult[1], parsedResult[2]);
    }

    private String[] parseCommand(String command) {
        return command.split(" ");
    }
}
