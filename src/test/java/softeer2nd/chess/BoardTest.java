package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;


public class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("getPawnsResult의 결과값을 검증한다.")
    public void initialize() throws Exception {
        assertEquals("pppppppprrnnbbqk", board.getWhitePiecesResult());
        assertEquals("PPPPPPPPRRNNBBQK", board.getBlackPiecesResult());
    }

    @Test
    @DisplayName("initialize() 실행 시 폰이 16개 생성된다.")
    public void initializePieceCount() {
        assertEquals(board.pieceCount(), 32);
    }

    @Test
    public void create() throws Exception {
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }
}