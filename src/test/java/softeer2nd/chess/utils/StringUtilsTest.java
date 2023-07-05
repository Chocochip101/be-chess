package softeer2nd.chess.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;


class StringUtilsTest {

    @Test
    @DisplayName("new line 문자를 추가하는 기능을 검증한다.")
    public void testNewLine() {
        StringBuilder stringBuilder = new StringBuilder();
        final String str1 = "Hi";
        stringBuilder.append(str1);
        StringBuilder result = stringBuilder.append(appendNewLine(str1));
        assertThat(result.toString()).contains("\n");
    }
}