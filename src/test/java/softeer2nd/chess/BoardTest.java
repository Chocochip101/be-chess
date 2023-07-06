package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.board.Board;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.List;

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
        Piece createdBlackRook1 = Piece.createBlackRook(p1);
        Piece createdBlackRook2 = Piece.createBlackRook(p2);
        Piece createdWhiteRook1 = Piece.createWhiteRook(p3);
        Piece createdWhiteRook2 = Piece.createWhiteRook(p4);

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
        Piece.createBlackRook(p1);
        Piece.createBlackRook(p2);
        Piece.createBlackRook(p3);

        //then
        assertEquals(2, board.countPieceByColorAndType(Piece.Color.BLACK, Piece.Type.ROOK));
    }

    @Test
    @DisplayName("임의의 기물을 체스판 위에 추가한다.")
    public void move() throws Exception {
        //given
        board.initialize();
        String start = "a8";
        String target = "a4";
        Piece piece = Piece.createBlackRook(new Point(start));

        //when
        board.move(target, piece);

        //then
        assertEquals(piece.getColor(), board.findPiece(target).getColor());
        assertEquals(piece.getType(), board.findPiece(target).getType());
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("체스 프로그램의 점수 계산을 검증한다.")
    public void calculatePointTest() throws Exception {
        //given
        board.initializeEmpty();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(1, 1);

        //when
        addPiece("b6", Piece.createBlackPawn(p1));
        addPiece("e6", Piece.createBlackQueen(p2));
        addPiece("b8", Piece.createBlackKing(p3));
        addPiece("c8", Piece.createBlackRook(p1));

        addPiece("f2", Piece.createWhitePawn(p1));
        addPiece("g2", Piece.createWhitePawn(p1));
        addPiece("e1", Piece.createWhiteRook(p1));
        addPiece("f1", Piece.createWhiteKing(p1));

        //then
        assertEquals(15.0, board.caculatePoint(Piece.Color.BLACK), 0.01);
        assertEquals(7.0, board.caculatePoint(Piece.Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("정렬 기능을 검증한다.")
    public void testSortScore() {
        //given
        board.initializeEmpty();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(1, 1);

        //when
        addPiece("b6", Piece.createBlackPawn(p1));
        addPiece("e6", Piece.createBlackQueen(p2));
        addPiece("b8", Piece.createBlackKing(p3));
        addPiece("c8", Piece.createBlackRook(p1));

        List<Piece> sortedPieces = board.sortPieceByScore(Piece.Color.BLACK);

        // then
        assertEquals(sortedPieces.get(0).getType(), Piece.Type.QUEEN);
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }
}