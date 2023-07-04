package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    Board board;
    Pawn white;
    Pawn black;

    @BeforeEach
    void setup() {
        board = new Board();
        white = new Pawn(Pawn.WHITE_COLOR);
        black = new Pawn(Pawn.BLACK_COLOR);
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
}