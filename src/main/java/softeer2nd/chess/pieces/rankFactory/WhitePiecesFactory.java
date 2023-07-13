package softeer2nd.chess.pieces.rankFactory;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.pieces.Point;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.pieces.PieceFactory.createPiece;

public class WhitePiecesFactory implements PiecesFactory {
    List<Piece> pieceList = new ArrayList<>();

    @Override
    public List<Piece> createPieces(int rowIndex) {
        pieceList.add(createPiece(Piece.Color.WHITE, Piece.Type.ROOK, new Point(0, rowIndex)));
        pieceList.add(createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT, new Point(1, rowIndex)));
        pieceList.add(createPiece(Piece.Color.WHITE, Piece.Type.BISHOP, new Point(2, rowIndex)));
        pieceList.add(createPiece(Piece.Color.WHITE, Piece.Type.QUEEN, new Point(3, rowIndex)));
        pieceList.add(createPiece(Piece.Color.WHITE, Piece.Type.KING, new Point(4, rowIndex)));
        pieceList.add(createPiece(Piece.Color.WHITE, Piece.Type.BISHOP, new Point(5, rowIndex)));
        pieceList.add(createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT, new Point(6, rowIndex)));
        pieceList.add(createPiece(Piece.Color.WHITE, Piece.Type.ROOK, new Point(7, rowIndex)));
        return pieceList;
    }
}
