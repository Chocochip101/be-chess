package softeer2nd.chess.pieces.factory;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BlackPiecesFactory implements PiecesFactory {
    List<Piece> pieceList = new ArrayList<>();

    @Override
    public List<Piece> createPiece(int rowIndex) {
        pieceList.add(Piece.createBlackRook(new Point(0, rowIndex)));
        pieceList.add(Piece.createBlackKnight(new Point(1, rowIndex)));
        pieceList.add(Piece.createBlackBishop(new Point(2, rowIndex)));
        pieceList.add(Piece.createBlackQueen(new Point(3, rowIndex)));
        pieceList.add(Piece.createBlackKing(new Point(4, rowIndex)));
        pieceList.add(Piece.createBlackBishop(new Point(5, rowIndex)));
        pieceList.add(Piece.createBlackKnight(new Point(6, rowIndex)));
        pieceList.add(Piece.createBlackRook(new Point(7, rowIndex)));
        return pieceList;
    }
}
