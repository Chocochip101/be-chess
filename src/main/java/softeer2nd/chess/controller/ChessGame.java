package softeer2nd.chess.controller;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("체스 프로그램을 시작합니다.");

        while (isRunning) {
            System.out.println("값을 입력하세요 (시작: 'start', 종료: 'exit'):");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                isRunning = false;
            } else if(input.equals("start")){
                Board board = new Board();
                board.initialize();
                board.print();
            }else{
                System.out.println("잘못 입력하셨습니다.");
            }
        }

        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
