package softeer2nd.chess.board.rankFactory;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static softeer2nd.chess.pieces.PieceFactory.createBlank;

public class BlankRankFactory implements RankFactory {
    private final static int COL_COUNT = 8;
    List<Piece> pieceList = new ArrayList<>();

    @Override
    public List<Piece> createPieces(int rowIndex) {
        IntStream.range(0, COL_COUNT)
                .forEach(col -> pieceList.add(createBlank(new Point(col, rowIndex))));
        return pieceList;
    }
}
