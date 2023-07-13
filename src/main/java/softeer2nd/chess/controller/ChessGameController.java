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

    public void startGame() {
        outputView.printStartProgram();
        Board board = new Board();
        board.initialize();
        while (true) {
            String command = inputView.gameCommand();
            isNotStartOrEndCommand(command);
            if (command.equals(END_COMMAND)) {
                break;
            }
            try {
                ChessGame chessGame = new ChessGame(board);
                String moveCommand = inputView.moveCommand();
                move(chessGame, moveCommand);
                outputView.print(board.showBoard());
            } catch (IllegalAccessException e) {
                outputView.print(e.toString());
            }
        }
    }

    private void isNotStartOrEndCommand(final String command) {
        if (!command.equals(START_COMMAND) && !command.equals(END_COMMAND)) {
            throw new IllegalArgumentException("잘못된 커맨드 입력입니다.");
        }
    }

    private void move(ChessGame chessGame, String command) throws IllegalAccessException {
        String[] parsedResult = parseCommand(command);
        chessGame.move(parsedResult[1], parsedResult[2]);
    }

    private String[] parseCommand(String command) {
        return command.split(" ");
    }
}
