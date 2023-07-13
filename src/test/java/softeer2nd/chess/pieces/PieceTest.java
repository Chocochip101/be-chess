package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.createPiece;

public class PieceTest {
    private Point pointZero;
    private Point pointOne;
    private Piece whitePawn;

    @BeforeEach
    void setup() {
        pointZero = new Point(0, 0);
        pointOne = new Point(1, 1);

        whitePawn = createPiece(Color.WHITE, Type.PAWN, pointZero);
    }

    @DisplayName("Piece의 색상을 비교한다.")
    @Test
    public void getRepresentationPerPiece() throws Exception {
        //given&when

        //then
        assertEquals('p', Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Type.PAWN.getBlackRepresentation());
    }

    @Test
    @DisplayName("createPawn으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_pawn() {
        //given&when
        Piece blackPawn = createPiece(Color.BLACK, Type.PAWN, pointOne);

        // then
        verifyPiece(whitePawn, blackPawn, Type.PAWN);
    }

    @Test
    @DisplayName("createRook으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_rook() {
        //given&when
        Piece whiteRook = createPiece(Color.WHITE, Type.ROOK, pointZero);
        Piece blackRook = createPiece(Color.BLACK, Type.ROOK, pointOne);

        //then
        verifyPiece(whiteRook, blackRook, Type.ROOK);
    }

    @Test
    @DisplayName("createBishop으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_bishop() {
        //given&when
        Piece whiteBishop = createPiece(Color.WHITE, Type.BISHOP, pointZero);
        Piece blackBishop = createPiece(Color.BLACK, Type.BISHOP, pointOne);

        //then
        verifyPiece(whiteBishop, blackBishop, Type.BISHOP);
    }

    @Test
    @DisplayName("createKnight으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_knight() {
        //given&when
        Piece whiteKnight = createPiece(Color.WHITE, Type.KNIGHT, pointZero);
        Piece blackKnight = createPiece(Color.BLACK, Type.KNIGHT, pointOne);

        //then
        verifyPiece(whiteKnight, blackKnight, Type.KNIGHT);
    }

    @Test
    @DisplayName("createQueen으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_queen() {
        //given&when
        Piece whiteQueen = createPiece(Color.WHITE, Type.QUEEN, pointZero);
        Piece blackQueen = createPiece(Color.BLACK, Type.QUEEN, pointOne);

        //then
        verifyPiece(whiteQueen, blackQueen, Type.QUEEN);
    }

    @Test
    @DisplayName("createKing으로 생성된 폰의 color와 representation을 검증한다.")
    public void create_piece_king() {
        //given&when
        Piece whiteKing = createPiece(Color.WHITE, Type.KING, pointZero);
        Piece blackKing = createPiece(Color.BLACK, Type.KING, pointOne);

        //then
        verifyPiece(whiteKing, blackKing, Type.KING);
    }


    @Test
    @DisplayName("isWhite()과 isBlack()을 검증한다.")
    public void checkIsWhite() {
        //given&when

        //then
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