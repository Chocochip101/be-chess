package softeer2nd.chess.pieces.rankFactory;

import softeer2nd.chess.pieces.Piece;

import java.util.List;

public interface PiecesFactory {
    List<Piece> createPieces(int rowIndex);
}
