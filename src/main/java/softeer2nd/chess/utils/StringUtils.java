package softeer2nd.chess.utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static String appendNewLine(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string).append(NEWLINE);
        return stringBuilder.toString();
    }
}