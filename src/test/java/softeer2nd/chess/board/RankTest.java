package softeer2nd.chess.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;
import softeer2nd.chess.pieces.factory.WhitePiecesFactory;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Move 검증")
    void move() {
        //given
        Rank rank = Rank.initializePieces(0, new WhitePiecesFactory());
        Point src = new Point("a1");
        Piece piece = Piece.createBlackRook(src);

        //when
        rank.move(0, piece);

        //then
        assertEquals(rank.findPiece(0), piece);
    }
}