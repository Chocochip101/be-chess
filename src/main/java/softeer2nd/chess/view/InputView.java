package softeer2nd.chess.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String START_COMMAND = "값을 입력하세요 (시작: 'start', 종료: 'end'):";
    private static final String MOVE_INPUT_COMMAND = "움직임을 입력하세요 (ex. move a1 b4)";

    public String gameCommand() {
        System.out.println(START_COMMAND);
        return scanner.nextLine();
    }

    public String moveCommand() {
        System.out.println(MOVE_INPUT_COMMAND);
        return scanner.nextLine();
    }
}
