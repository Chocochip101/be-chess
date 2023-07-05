package softeer2nd.chess.view;

public class OutputView {
    private static final String WELCOME_COMMAND = "체스 프로그램을 시작합니다.";
    private static final String FINISH_COMMAND = "프로그램을 종료합니다.";
    private static final String WRONG_COMMAND = "잘못 입력하셨습니다.";

    public void printStartProgram() {
        System.out.println(WELCOME_COMMAND);
    }

    public void printFinishProgram() {
        System.out.println(FINISH_COMMAND);
    }

    public void printWrongCommand() {
        System.out.println(WRONG_COMMAND);
    }
}
