package softeer2nd.chess.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {
    private Piece white;

    @BeforeEach
    void setup() {
        white = new Piece();
    }

    @Test
    public void create_기본생성자() throws Exception {
        assertEquals(Piece.WHITE_COLOR, white.getColor());
        assertEquals(Piece.WHITE_REPRESENTATION, white.getRepresentation());
    }

    @Test
    @DisplayName("색상에 맞는 폰이 생성되어야 한다")
    public void create() {
        verifyPiece(Piece.WHITE_COLOR, Piece.WHITE_REPRESENTATION);
        verifyPiece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION);
    }


    private void verifyPiece(final String color, final char representation) {
        Piece piece = new Piece(color, representation, 0, 0);
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
    }
}