package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    private Board board;
    private Pawn white;
    private Pawn black;

    @BeforeEach
    void setup() {
        board = new Board();
        white = new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION, 6, 0);
        black = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION, 1, 1);
    }

    @Test
    @DisplayName("체스판에 폰이 추가되는지 확인한다.")
    public void create() throws Exception {
        board.add(white);
        assertEquals(1, board.size());
        assertEquals(white, board.findPawn(0));

        board.add(black);
        assertEquals(2, board.size());
        assertEquals(black, board.findPawn(1));
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
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());
    }
}