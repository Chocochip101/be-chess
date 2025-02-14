package softeer2nd.chess.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.board.Board;
import softeer2nd.chess.exception.BlankException;
import softeer2nd.chess.exception.IllegalMovePositionException;
import softeer2nd.chess.exception.IllegalTurnException;
import softeer2nd.chess.exception.OutOfBoardException;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.PieceFactory.createBlank;
import static softeer2nd.chess.pieces.PieceFactory.createPiece;

class ChessGameTest {
    private Board board;
    private ChessGame chessGame;

    @BeforeEach
    void setup() {
        board = new Board();
        board.initialize();
        chessGame = new ChessGame(board);
    }

    @Test
    @DisplayName("기물의 이동을 구현한다.")
    public void move() throws Exception {
        // given
        String sourcePosition = "b2";
        String targetPosition = "b3";

        // when
        chessGame.move(sourcePosition, targetPosition);

        // then
        assertTrue(createBlank(new Point(sourcePosition)).equals(board.findPiece(sourcePosition)));
        assertTrue(createPiece(Piece.Color.WHITE, Piece.Type.PAWN, new Point(targetPosition)).equals(board.findPiece(targetPosition)));
    }

    @Test
    @DisplayName("킹의 이동을 구현한다.")
    public void moveKing() {
        // given
        ChessGame chessGame = new ChessGame(board);
        chessGame.move("e2", "e3");
        chessGame.move("a7", "a6");

        // when
        String sourcePosition = "e1";
        String targetPosition = "e2";
        chessGame.move(sourcePosition, targetPosition);

        // then
        assertTrue(board.findPiece(targetPosition).getType().equals(Piece.Type.KING));
        assertTrue(board.findPiece(targetPosition).getColor().equals(Piece.Color.WHITE));
    }

    @Test
    @DisplayName("킹은 체스판 밖으로 이동할 수 없다.")
    public void KingOutofBoard() throws Exception {
        //given
        String sourcePosition = "e1";
        String targetPosition = "e0";

        //when&then
        assertThrows(OutOfBoardException.class, () -> {
            chessGame.move(sourcePosition, targetPosition);
        });
    }

    @Test
    @DisplayName("킹은 이동하려는 위치에 같은 편의 기물이 있을 경우, 움직일 수 없다.")
    public void kingMovingToSameColor() throws Exception {
        //given
        String sourcePosition = "e1";
        String targetPosition = "e2";

        //when&then
        assertThrows(IllegalMovePositionException.class, () -> {
            chessGame.move(sourcePosition, targetPosition);
        });
    }

    @Test
    @DisplayName("킹은 두 칸 이상 움직일 수 없다.")
    public void kingMovingTwo() throws Exception {
        //given
        String sourcePosition = "e1";
        String targetPosition = "e3";

        //when&then
        assertThrows(IllegalMovePositionException.class, () -> {
            chessGame.move(sourcePosition, targetPosition);
        });
    }

    @Test
    @DisplayName("퀸의 이동을 구현한다.")
    public void moveQueen() throws Exception {
        //given
        chessGame.move("d2", "d3");
        chessGame.move("a7", "a6");

        //when
        String sourcePosition = "d1";
        String targetPosition = "d2";
        chessGame.move(sourcePosition, targetPosition);

        // then
        assertTrue(board.findPiece(targetPosition).getType().equals(Piece.Type.QUEEN));
        assertTrue(board.findPiece(targetPosition).getColor().equals(Piece.Color.WHITE));
    }

    @Test
    @DisplayName("퀸은 체스판 밖으로 이동할 수 없다.")
    public void QueenOutOfBoard() throws Exception {
        //given
        String sourcePosition = "d1";
        String targetPosition = "d0";

        //when&then
        assertThrows(OutOfBoardException.class, () -> {
            chessGame.move(sourcePosition, targetPosition);
        });
    }

    @Test
    @DisplayName("킹은 이동하려는 위치에 같은 편의 기물이 있을 경우, 움직일 수 없다.")
    public void QueenMovingToSameColor() throws Exception {
        //given
        String sourcePosition = "d1";
        String targetPosition = "d2";
        ChessGame chessGame = new ChessGame(board);

        //when&then
        assertThrows(IllegalMovePositionException.class, () -> {
            chessGame.move(sourcePosition, targetPosition);
        });
    }

    @Test
    @DisplayName("이동하려는 위치에 기물이 존재할 경우, 예외가 발생한다.")
    public void movementImpossible() throws Exception {
        // given
        String source = "a1";
        String target = "a3";

        // when
        ChessGame chessGame = new ChessGame(board);

        // then
        assertThrows(IllegalMovePositionException.class, () -> {
            chessGame.move(source, target);
        });
    }

    @Test
    @DisplayName("빈 칸은 움직이려는 경우, 예외가 발생한다.")
    public void selectedBlankPiece() throws Exception {
        //given
        String source = "a3";
        String target = "a4";

        // when
        ChessGame chessGame = new ChessGame(board);

        //then
        assertThrows(BlankException.class, () -> {
            chessGame.move(source, target);
        });
    }

    @Test
    @DisplayName("해당 턴이 아닐 시, 예외가 발생한다.")
    public void turnExceptionTest() throws Exception {
        //given
        chessGame.move("d2", "d3");

        //when&then
        assertThrows(IllegalTurnException.class, () -> {
            chessGame.move("a2", "a3");
        });
    }
}