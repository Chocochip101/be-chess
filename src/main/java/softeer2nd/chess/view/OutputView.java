package softeer2nd.chess.view;

public class OutputView {
    private static final String WELCOME_COMMAND = "체스 프로그램을 시작합니다.";
    private static final String FINISH_COMMAND = "프로그램을 종료합니다.";
    private static final String WRONG_COMMAND = "잘못 입력하셨습니다. 종료합니다.";
    private static final String WRITE_COMMAND = "명령을 입력해주세요.";

    public void printStartProgram() {
        System.out.println(WELCOME_COMMAND);
    }

    public void printFinishProgram() {
        System.out.println(FINISH_COMMAND);
    }

    public void printWrongCommand() {
        System.out.println(WRONG_COMMAND);
    }

    public void writeCommand() {
        System.out.println(WRITE_COMMAND);
    }

    public void print(String result) {
        System.out.println(result);
    }
}
