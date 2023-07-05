package softeer2nd.chess.view;

import java.util.Scanner;

public class InputView {
    private static final String GAME_INPUT_COMMAND = "값을 입력하세요 (시작: 'start', 종료: 'end'):";

    public String inputUserCommand(Scanner scanner) {
        System.out.println(GAME_INPUT_COMMAND);
        return scanner.nextLine();
    }
}
