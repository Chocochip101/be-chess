package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    private Point pointZero;
    private Point pointOne;
    private Piece whitePawn;

    @BeforeEach
    void setup() {
        pointZero = new Point(0, 0);
        pointOne = new Point(1, 1);
        whitePawn = Piece.createWhitePawn(pointZero);
    }

    @Test
    @DisplayName("Piece의 색상을 비교한다.")
    public void Piece_색상비교() throws Exception {
        assertEquals(Piece.WHITE_COLOR, whitePawn.getColor());
        assertEquals(Piece.WHITE_PAWN_REPRESENTATION, whitePawn.getRepresentation());
    }

    @Test
    @DisplayName("createPawn으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_pawn() {
        verifyPiece(Piece.createWhitePawn(pointZero), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPiece(Piece.createBlackPawn(pointOne), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
    }

    @Test
    @DisplayName("createRook으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_rook() {
        verifyPiece(Piece.createWhiteRook(pointZero), Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPiece(Piece.createBlackRook(pointOne), Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
    }

    @Test
    @DisplayName("createBishop으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_bishop() {
        verifyPiece(Piece.createWhiteBishop(pointZero), Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPiece(Piece.createBlackBishop(pointOne), Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);
    }

    @Test
    @DisplayName("createKnight으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_knight() {
        verifyPiece(Piece.createWhiteKnight(pointZero), Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPiece(Piece.createBlackKnight(pointOne), Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
    }

    @Test
    @DisplayName("createQueen으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_queen() {
        verifyPiece(Piece.createWhiteQueen(pointZero), Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPiece(Piece.createBlackQueen(pointOne), Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
    }

    @Test
    @DisplayName("createKing으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_king() {
        verifyPiece(Piece.createWhiteKing(pointZero), Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
        verifyPiece(Piece.createBlackKing(pointOne), Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
    }

    @Test
    @DisplayName("isWhite()과 isBlack()을 검증한다.")
    public void checkIsWhite() {
        assertTrue(whitePawn.isWhite());
        assertFalse(whitePawn.isBlack());
    }

    private void verifyPiece(final Piece piece, final String color, final char representation) {
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}