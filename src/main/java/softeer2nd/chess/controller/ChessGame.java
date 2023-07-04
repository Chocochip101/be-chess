package softeer2nd.chess.controller;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class ChessGame {
    private static final String WELCOME_COMMAND = "체스 프로그램을 시작합니다.";
    private static final String GAME_INPUT_COMMAND = "값을 입력하세요 (시작: 'start', 종료: 'end'):";
    private static final String WRONG_COMMAND = "잘못 입력하셨습니다.";
    private static final String FINISH_COMMAND = "프로그램을 종료합니다.";
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println(WELCOME_COMMAND);

        while (isRunning) {
            System.out.println(GAME_INPUT_COMMAND);
            String input = scanner.nextLine();

            if (input.equals(END_COMMAND)) {
                isRunning = false;
            } else if (input.equals(START_COMMAND)) {
                Board board = new Board();
                board.initialize();
                board.print();
            } else {
                System.out.println(WRONG_COMMAND);
            }
        }

        System.out.println(FINISH_COMMAND);
        scanner.close();
    }
}
