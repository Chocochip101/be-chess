package softeer2nd.chess.pieces.factory;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.ArrayList;
import java.util.List;

public class WhitePiecesFactory implements PiecesFactory {
    List<Piece> pieceList = new ArrayList<>();

    @Override
    public List<Piece> createPiece(int rowIndex) {
        pieceList.add(Piece.createWhiteRook(new Point(0, rowIndex)));
        pieceList.add(Piece.createWhiteKnight(new Point(1, rowIndex)));
        pieceList.add(Piece.createWhiteBishop(new Point(2, rowIndex)));
        pieceList.add(Piece.createWhiteQueen(new Point(3, rowIndex)));
        pieceList.add(Piece.createWhiteKing(new Point(4, rowIndex)));
        pieceList.add(Piece.createWhiteBishop(new Point(5, rowIndex)));
        pieceList.add(Piece.createWhiteKnight(new Point(6, rowIndex)));
        pieceList.add(Piece.createWhiteRook(new Point(7, rowIndex)));
        return pieceList;
    }
}
