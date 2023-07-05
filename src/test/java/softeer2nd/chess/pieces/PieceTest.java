package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;

public class PieceTest {
    private Point pointZero;
    private Point pointOne;
    private Piece whitePawn;

    @BeforeEach
    void setup() {
        pointZero = new Point(0, 0);
        pointOne = new Point(1, 1);
        whitePawn = createWhitePawn(pointZero);
    }

    @DisplayName("Piece의 색상을 비교한다.")
    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Type.PAWN.getBlackRepresentation());
    }

    @Test
    @DisplayName("createPawn으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_pawn() {
        //given&when
        Piece blackPawn = createBlackPawn(pointOne);

        // then
        verifyPiece(whitePawn, blackPawn, Type.PAWN);
    }

    @Test
    @DisplayName("createRook으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_rook() {
        //given&when
        Piece whiteRook = createWhiteRook(pointZero);
        Piece blackRook = createBlackRook(pointOne);

        //then
        verifyPiece(whiteRook, blackRook, Type.ROOK);
    }

    @Test
    @DisplayName("createBishop으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_bishop() {
        //given&when
        Piece whiteBishop = createWhiteBishop(pointZero);
        Piece blackBishop = createBlackBishop(pointOne);

        //then
        verifyPiece(whiteBishop, blackBishop, Type.BISHOP);
    }

    @Test
    @DisplayName("createKnight으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_knight() {
        //given&when
        Piece whiteKnight = createWhiteKnight(pointOne);
        Piece blackKnight = createBlackKnight(pointZero);

        //then
        verifyPiece(whiteKnight, blackKnight, Type.KNIGHT);
    }

    @Test
    @DisplayName("createQueen으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_queen() {
        //given&when
        Piece whiteQueen = createWhiteQueen(pointOne);
        Piece blackQueen = createBlackQueen(pointZero);

        //then
        verifyPiece(whiteQueen, blackQueen, Type.QUEEN);
    }

    @Test
    @DisplayName("createKing으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_king() {
        //given&when
        Piece whiteKing = createWhiteKing(pointOne);
        Piece blackKing = createBlackKing(pointZero);

        //then
        verifyPiece(whiteKing, blackKing, Type.KING);
    }

    @Test
    @DisplayName("isWhite()과 isBlack()을 검증한다.")
    public void checkIsWhite() {
        assertTrue(whitePawn.isWhite());
        assertFalse(whitePawn.isBlack());
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());
    }
}