package softeer2nd.chess.pieces.factory;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WhitePawnPiecesFactory implements PiecesFactory {
    private final static int COL_COUNT = 8;
    List<Piece> pieceList = new ArrayList<>();

    @Override
    public List<Piece> createPiece(int rowIndex) {
        IntStream.range(0, COL_COUNT)
                .forEach(col -> pieceList.add(Piece.createWhitePawn(new Point(col, rowIndex))));
        return pieceList;
    }
}
