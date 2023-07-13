package softeer2nd.chess.board.rankFactory;

import softeer2nd.chess.pieces.Piece;

import java.util.List;

public interface RankFactory {
    List<Piece> createPieces(int rowIndex);
}
