package softeer2nd.chess.pieces.factory;

import softeer2nd.chess.pieces.Piece;

import java.util.List;

public interface PiecesFactory {
    List<Piece> createPiece(int rowIndex);
}
