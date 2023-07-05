package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    private Board board;
    private Piece white;
    private Piece black;

    @BeforeEach
    void setup() {
        board = new Board();
        white = new Piece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION, 6, 0);
        black = new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION, 1, 1);
    }

    @Test
    @DisplayName("체스판에 폰이 추가되는지 확인한다.")
    public void create() throws Exception {
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPiece(0));

        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPiece(1));
    }

    @Test
    @DisplayName("체스판에 폰 이외에 추가 시 컴파일 에러를 발생한다.")
    public void addNotPawn() throws Exception {

//        assertThrows(board.add(new Integer("7")));
    }

    @Test
    @DisplayName("getPawnsResult의 결과값을 검증한다.")
    public void initialize() throws Exception {
        board.initialize();
        assertEquals("pppppppp", board.getWhitePiecesResult());
        assertEquals("PPPPPPPP", board.getBlackPiecesResult());
    }

    @Test
    @DisplayName("initialize() 실행 시 폰이 16개 생성된다.")
    public void initializePieceCount() {
        board.add(white);
        board.initialize();
        assertEquals(board.size(), 16);
    }

}