package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;


public class BoardTest {
    private Board board;
    private Piece white;
    private Piece black;

    @BeforeEach
    void setup() {
        board = new Board();
        white = Piece.createWhitePawn(new Point(0, 0));
        black = Piece.createBlackPawn(new Point(1, 1));
    }

    @Test
    @DisplayName("getPawnsResult의 결과값을 검증한다.")
    public void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppprrnnbbqk", board.getWhitePiecesResult());
        assertEquals("PPPPPPPPRRNNBBQK", board.getBlackPiecesResult());
    }

    @Test
    @DisplayName("initialize() 실행 시 폰이 16개 생성된다.")
    public void initializePieceCount() {
        board.add(white);
        board.initialize();
        assertEquals(board.pieceCount(), 32);
    }

    @Test
    public void create() throws Exception {
        board.initialize();
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