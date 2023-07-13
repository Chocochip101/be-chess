package softeer2nd.chess.controller;

import softeer2nd.chess.board.Board;
import softeer2nd.chess.exception.*;
import softeer2nd.chess.game.ChessGame;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.view.InputView;
import softeer2nd.chess.view.OutputView;

public class ChessGameController {
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";
    private static final String MOVE_COMMAND = "move";
    private static final int MOVE_COMMAND_LENGTH = 3;

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startGame() {
        outputView.printStartProgram();
        Board board = new Board();
        board.initialize();
        ChessGame chessGame = new ChessGame(board);
        String command = inputView.gameCommand();
        try {
            isNotStartOrEndCommand(command);
        } catch (WrongCommandException e) {
            outputView.print(e.getMessage());
        }
        if (command.equals(END_COMMAND)) {
            return;
        }
        while (true) {
            try {
                outputView.turnCommand(chessGame.getTurn());
                String moveCommand = inputView.moveCommand();
                if (!move(chessGame, moveCommand)) {
                    outputView.printWhiteScore(board.calculatePoint(Piece.Color.WHITE));
                    outputView.printBlackScore(board.calculatePoint(Piece.Color.BLACK));
                    outputView.terminateProgram();
                    break;
                }
                outputView.print(board.showBoard());
            } catch (WrongCommandException | IllegalTurnException | OutOfBoardException |
                     BlankException | IllegalMovePositionException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private void isNotStartOrEndCommand(final String command) {
        if (!command.equals(START_COMMAND) && !command.equals(END_COMMAND)) {
            throw new WrongCommandException();
        }
    }

    private boolean move(ChessGame chessGame, String command) {
        String[] parsedResult = parseCommand(command);
        if (checkEndCommand(parsedResult)) return false;
        isWrongMoveCommand(parsedResult);
        isNotMoveCommand(parsedResult[0]);
        chessGame.move(parsedResult[1], parsedResult[2]);
        return true;
    }

    private static boolean checkEndCommand(String[] parsedResult) {
        return parsedResult.length == 1 && parsedResult[0].equals(END_COMMAND);
    }

    private String[] parseCommand(final String command) {
        return command.split(" ");
    }

    private void isNotMoveCommand(final String command) {
        if (!command.equals(MOVE_COMMAND)) {
            throw new WrongCommandException();
        }
    }

    private void isWrongMoveCommand(final String[] parsedResult) {
        if (parsedResult.length != MOVE_COMMAND_LENGTH) {
            throw new WrongCommandException();
        }
    }
}
