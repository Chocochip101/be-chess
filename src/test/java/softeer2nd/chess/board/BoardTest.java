package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.board.Board;
import softeer2nd.chess.game.ChessGame;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.PieceFactory.createPiece;
import static softeer2nd.chess.utils.StringUtils.appendNewLine;


public class BoardTest {
    private Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
    }

    @Test
    @DisplayName("create test")
    public void create() throws Exception {
        //given&when
        String blankRank = appendNewLine("........");

        //then
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

    @Test
    @DisplayName("Board 생성 테스트")
    public void initializeTest() {
    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회한다.")
    public void findPiece() throws Exception {
        //given
        Point p1 = new Point("a8");
        Point p2 = new Point("h8");
        Point p3 = new Point("a1");
        Point p4 = new Point("h1");

        //when
        Piece createdBlackRook1 = createPiece(Piece.Color.BLACK, Piece.Type.ROOK, p1);
        Piece createdBlackRook2 = createPiece(Piece.Color.BLACK, Piece.Type.ROOK, p2);
        Piece createdWhiteRook1 = createPiece(Piece.Color.WHITE, Piece.Type.ROOK, p3);
        Piece createdWhiteRook2 = createPiece(Piece.Color.WHITE, Piece.Type.ROOK, p4);

        //then
        assertEquals(createdBlackRook1, board.findPiece("a8"));
        assertEquals(createdBlackRook2, board.findPiece("h8"));
        assertEquals(createdWhiteRook1, board.findPiece("a1"));
        assertEquals(createdWhiteRook2, board.findPiece("h1"));
    }

    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환한다.")
    public void countPieceByColorAndTypeTest() throws Exception {
        //given
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(1, 1);

        //when
        createPiece(Piece.Color.BLACK, Piece.Type.ROOK, p1);
        createPiece(Piece.Color.BLACK, Piece.Type.ROOK, p2);
        createPiece(Piece.Color.BLACK, Piece.Type.ROOK, p3);

        //then
        assertEquals(2, board.countPieceByColorAndType(Piece.Color.BLACK, Piece.Type.ROOK));
    }

}